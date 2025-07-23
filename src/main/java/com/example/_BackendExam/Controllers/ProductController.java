package com.example._BackendExam.Controllers;

import com.example._BackendExam.DTO.ProductDTO;
import com.example._BackendExam.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO dto) {
        return productService.createProduct(dto);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable int id, @RequestBody ProductDTO dto) {
        return productService.updateProduct(id, dto);
    }
}
