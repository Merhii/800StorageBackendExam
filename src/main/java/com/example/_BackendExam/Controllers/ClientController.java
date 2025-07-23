package com.example._BackendExam.Controllers;

import com.example._BackendExam.DTO.ClientDTO;
import com.example._BackendExam.Services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO dto) {
        return clientService.createClient(dto);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable int id, @RequestBody ClientDTO dto) {
        return clientService.updateClient(id, dto);
    }
}
