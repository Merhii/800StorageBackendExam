package com.example._BackendExam.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int productID;
    private String productName;
    private String productDescription;
    private String productCategory;
    private Date productCreationDate;
}
