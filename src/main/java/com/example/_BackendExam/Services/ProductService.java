package com.example._BackendExam.Services;

import com.example._BackendExam.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO createProduct(ProductDTO dto);
    ProductDTO updateProduct(int id, ProductDTO dto);
}
