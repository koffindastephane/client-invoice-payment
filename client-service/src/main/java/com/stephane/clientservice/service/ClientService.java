package com.stephane.clientservice.service;

import com.stephane.clientservice.entity.Client;

import java.util.List;

public interface ClientService {

    public Client createClient(Client client);
    public List<Client> getAllClients();
    public Client getClientById(Long id);

}
