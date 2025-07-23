package com.example._BackendExam.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {
    private int saleID;
    private int clientID;
    private String clientName;
    private String seller;
    private double total;
    private Date saleDate;
    private List<ProductSaleDTO> productSales;
}
