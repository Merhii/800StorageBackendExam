package com.example._BackendExam.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaleDTO {
    private int id;
    private int productID;
    private int quantity;
    private double price;



}
