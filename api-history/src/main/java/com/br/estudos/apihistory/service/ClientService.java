package com.br.estudos.apihistory.service;

import com.br.estudos.apihistory.dto.ClientResponseDto;
import com.br.estudos.apihistory.dto.ClientDto;
import com.br.estudos.apihistory.entity.ClientEntity;
import com.br.estudos.apihistory.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientResponseDto getAllClients() {
        return mapperToResponse(clientRepository.findAll());
    }

    private ClientResponseDto mapperToResponse(List<ClientEntity> all) {
        Integer size = all.size();
        List<ClientDto> clientsDto = new ArrayList<>();
        all.forEach(client ->
            clientsDto.add(new ClientDto(client.getId(), client.getName(), client.getEmail())));
        return new ClientResponseDto(size,clientsDto);
    }
}
