package com.example._BackendExam.ServiceImplementation;

import com.example._BackendExam.DTO.ProductSaleDTO;
import com.example._BackendExam.DTO.SaleDTO;
import com.example._BackendExam.Entity.Client;
import com.example._BackendExam.Entity.Product;
import com.example._BackendExam.Entity.ProductSale;
import com.example._BackendExam.Entity.Sale;
import com.example._BackendExam.Repository.ClientRepository;
import com.example._BackendExam.Repository.ProductRepository;
import com.example._BackendExam.Repository.ProductSaleRepository;
import com.example._BackendExam.Repository.SaleRepository;
import com.example._BackendExam.Services.SaleService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final ProductSaleRepository productSaleRepository;

    @Override
    public List<SaleDTO> getAllSales() {
        return saleRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SaleDTO createSale(SaleDTO dto) {
        Client client = clientRepository.findById(dto.getClientID())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Sale sale = new Sale();
        sale.setClient(client);
        sale.setSeller(dto.getSeller());
        sale.setSaleDate(Date.valueOf(LocalDate.now()));

        Sale savedSale = saleRepository.save(sale);

        double total = 0.0;

        for (ProductSaleDTO psDto : dto.getProductSales()) {
            Product product = productRepository.findById(psDto.getProductID())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            ProductSale ps = new ProductSale();
            ps.setSale(savedSale);
            ps.setProduct(product);
            ps.setQuantity(psDto.getQuantity());
            ps.setPrice(psDto.getPrice());

            total +=(ps.getPrice()*ps.getQuantity());
            productSaleRepository.save(ps);
        }

        savedSale.setTotal(total);
        saleRepository.save(savedSale);

        return mapToDTO(savedSale);
    }

    @Override
    public SaleDTO updateSaleTransactions(int saleId, List<ProductSaleDTO> updates) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new RuntimeException("Sale not found"));

        double newTotal = 0.0;

        for (ProductSaleDTO update : updates) {
            ProductSale ps = productSaleRepository.findById(update.getId())
                    .orElseThrow(() -> new RuntimeException("ProductSale not found"));

            int oldQty = ps.getQuantity();
            double oldPrice = ps.getPrice();

            ps.setQuantity(update.getQuantity());
            ps.setPrice(update.getPrice());

            productSaleRepository.save(ps);


            log.info("Sale Update | saleID={}, productID={}, oldQty={}, newQty={}, oldPrice={}, newPrice={}",
                    saleId, ps.getProduct().getProductID(), oldQty, update.getQuantity(), oldPrice, update.getPrice());

            newTotal +=(ps.getPrice()*ps.getQuantity());
        }

        sale.setTotal(newTotal);
        saleRepository.save(sale);

        return mapToDTO(sale);
    }

    private SaleDTO mapToDTO(Sale sale) {
        List<ProductSaleDTO> productSales = productSaleRepository.findAll().stream()
                .filter(ps -> ps.getSale().getSaleID() == sale.getSaleID())
                .map(ps -> new ProductSaleDTO(
                        ps.getId(),
                        ps.getProduct().getProductID(),
                        ps.getQuantity(),
                        ps.getPrice()

                )).collect(Collectors.toList());

        return new SaleDTO(
                sale.getSaleID(),
                sale.getClient().getClientID(),
                sale.getClient().getClientFirstName() + " " + sale.getClient().getClientLastName(),
                sale.getSeller(),
                sale.getTotal(),
                sale.getSaleDate(),
                productSales
        );
    }
}
