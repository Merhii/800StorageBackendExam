package com.example._BackendExam.Controllers;

import com.example._BackendExam.DTO.ProductSaleDTO;
import com.example._BackendExam.DTO.SaleDTO;
import com.example._BackendExam.Services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public List<SaleDTO> getAllSales() {
        return saleService.getAllSales();
    }

    @PostMapping
    public SaleDTO createSale(@RequestBody SaleDTO dto) {
        return saleService.createSale(dto);
    }

    @PutMapping("/{id}/transactions")
    public SaleDTO updateSaleTransactions(@PathVariable int id, @RequestBody List<ProductSaleDTO> updates) {
        return saleService.updateSaleTransactions(id, updates);
    }
}
