package com.example._BackendExam.Repository;

import com.example._BackendExam.Entity.Product;
import com.example._BackendExam.Entity.ProductSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSaleRepository extends JpaRepository<ProductSale, Integer> {
}
