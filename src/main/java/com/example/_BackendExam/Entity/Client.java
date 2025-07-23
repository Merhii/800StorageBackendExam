package com.example._BackendExam.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue
    private int clientID;
    private String clientFirstName;
    private String clientLastName;
    private String clientMobileNumber;
}
