package com.example._BackendExam.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private int productID;
    private String productName;
    private String productDescription;
    private String productCategory;
    private Date productCreationDate;
}
