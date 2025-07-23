package com.example._BackendExam.Repository;

import com.example._BackendExam.Entity.Client;
import com.example._BackendExam.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
