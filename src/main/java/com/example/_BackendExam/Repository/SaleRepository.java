package com.example._BackendExam.Repository;

import com.example._BackendExam.Entity.Product;
import com.example._BackendExam.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
