package com.example._BackendExam.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data

public class ProductSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Id
    private int productID;

    @Id
    private int saleID;

    private int quantity;
    private double price;

    @ManyToOne
    @MapsId("productID")
    private Product product;

    @ManyToOne
    @MapsId("saleID")
    private Sale sale;
}
