package com.example._BackendExam.ServiceImplementation;

import com.example._BackendExam.DTO.ProductDTO;
import com.example._BackendExam.Entity.Product;
import com.example._BackendExam.Repository.ProductRepository;
import com.example._BackendExam.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        Product product = mapToEntity(dto);
        product.setProductCreationDate(Date.valueOf(LocalDate.now()));
        Product saved = productRepository.save(product);
        return mapToDTO(saved);
    }

    @Override
    public ProductDTO updateProduct(int id, ProductDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setProductName(dto.getProductName());
        product.setProductDescription(dto.getProductDescription());
        product.setProductCategory(dto.getProductCategory());

        return mapToDTO(productRepository.save(product));
    }

    private ProductDTO mapToDTO(Product p) {
        return new ProductDTO(p.getProductID(), p.getProductName(), p.getProductDescription(), p.getProductCategory(), p.getProductCreationDate());
    }

    private Product mapToEntity(ProductDTO dto) {
        Product p = new Product();
        p.setProductID(dto.getProductID());
        p.setProductName(dto.getProductName());
        p.setProductDescription(dto.getProductDescription());
        p.setProductCategory(dto.getProductCategory());
        p.setProductCreationDate(dto.getProductCreationDate());
        return p;
    }
}

