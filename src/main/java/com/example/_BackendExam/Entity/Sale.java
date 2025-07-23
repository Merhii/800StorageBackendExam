package com.example._BackendExam.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@Data

public class Sale {
    @Id
    @GeneratedValue
    private int saleID;

    @MapsId("clientID")
    private Client client;

    private String seller;
    private double total;
    private Date saleDate;
}
