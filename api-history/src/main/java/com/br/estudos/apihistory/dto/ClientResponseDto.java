package com.br.estudos.apihistory.dto;

import java.util.List;

public class ClientResponseDto {
    private final Integer qtt;
    private final List<ClientDto> clients;

    public ClientResponseDto(Integer qtt, List<ClientDto> clients) {
        this.qtt = qtt;
        this.clients = clients;
    }

    public Integer getQtt() {
        return qtt;
    }

    public List<ClientDto> getClients() {
        return clients;
    }
}
