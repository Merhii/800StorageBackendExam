package com.example._BackendExam.Services;

import com.example._BackendExam.DTO.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getAllClients();
    ClientDTO createClient(ClientDTO dto);
    ClientDTO updateClient(int id, ClientDTO dto);
}
