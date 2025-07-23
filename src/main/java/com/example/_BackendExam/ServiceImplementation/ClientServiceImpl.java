package com.example._BackendExam.ServiceImplementation;

import com.example._BackendExam.DTO.ClientDTO;
import com.example._BackendExam.Entity.Client;
import com.example._BackendExam.Repository.ClientRepository;
import com.example._BackendExam.Services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO createClient(ClientDTO dto) {
        Client client = mapToEntity(dto);
        Client saved = clientRepository.save(client);
        return mapToDTO(saved);
    }

    @Override
    public ClientDTO updateClient(int id, ClientDTO dto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        client.setClientFirstName(dto.getClientFirstName());
        client.setClientLastName(dto.getClientLastName());
        client.setClientMobileNumber(dto.getClientMobileNumber());

        return mapToDTO(clientRepository.save(client));
    }

    private ClientDTO mapToDTO(Client client) {
        return new ClientDTO(
                client.getClientID(),
                client.getClientFirstName(),
                client.getClientLastName(),
                client.getClientMobileNumber()
        );
    }

    private Client mapToEntity(ClientDTO dto) {
        Client c = new Client();
        c.setClientID(dto.getClientID());
        c.setClientFirstName(dto.getClientFirstName());
        c.setClientLastName(dto.getClientLastName());
        c.setClientMobileNumber(dto.getClientMobileNumber());
        return c;
    }
}
