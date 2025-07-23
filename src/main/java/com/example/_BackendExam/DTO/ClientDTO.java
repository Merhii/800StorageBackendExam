package com.example._BackendExam.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private int clientID;
    private String clientFirstName;
    private String clientLastName;
    private String clientMobileNumber;
}
