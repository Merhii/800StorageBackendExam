package com.example._BackendExam.Services;

import com.example._BackendExam.DTO.ProductSaleDTO;
import com.example._BackendExam.DTO.SaleDTO;

import java.util.List;

public interface SaleService {
    List<SaleDTO> getAllSales();
    SaleDTO createSale(SaleDTO dto);
    SaleDTO updateSaleTransactions(int saleId, List<ProductSaleDTO> updates);
}
