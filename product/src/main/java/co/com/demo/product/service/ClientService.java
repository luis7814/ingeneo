package co.com.demo.product.service;

import co.com.demo.product.model.Client;
import co.com.demo.product.object.ClientDto;
import co.com.demo.product.repository.ClientRepository;
import co.com.demo.product.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientDto save(ClientDto clientDto) {
        clientDto.setClientId(Utilities.id());
        clientRepository.save(mapperToModel(clientDto));
        return clientDto;
    }

    public ClientDto update(ClientDto clientDto) {
        clientRepository.save(mapperToModel(clientDto));
        return clientDto;
    }

    public ClientDto findById(String id) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            return mapperToDto(optionalClient.get());
        }
        return null;
    }

    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(this::mapperToDto)
                .collect(Collectors.toList());
    }

    private ClientDto mapperToDto(Client client) {

        ClientDto clientDto = new ClientDto();
        clientDto.setClientId(client.getClientId());
        clientDto.setName(client.getName());
        clientDto.setEmail(client.getEmail());
        clientDto.setMobilePhone(client.getMobilePhone());

        return clientDto;

    }

    private Client mapperToModel(ClientDto clientDto) {

        Client client = new Client();
        client.setClientId(clientDto.getClientId());
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client.setMobilePhone(clientDto.getMobilePhone());

        return client;

    }
}
