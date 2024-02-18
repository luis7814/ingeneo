package co.com.demo.product.service;

import co.com.demo.product.model.Client;
import co.com.demo.product.object.ClientDto;
import co.com.demo.product.object.DestinationDto;
import co.com.demo.product.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class ClientServiceTest {
    @Mock
    ClientRepository clientRepository;
    @InjectMocks
    ClientService clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        ClientDto result = clientService.save(clientDtoData());
        Assertions.assertEquals("Name", result.getName());
    }

    @Test
    void testUpdate() {
        ClientDto result = clientService.update(clientDtoData());
        Assertions.assertEquals("Name", result.getName());
    }

    @Test
    void testFindById() {
        when(clientRepository.findById("id")).thenReturn((Optional.of(clientData())));
        ClientDto result = clientService.findById("id");
        Assertions.assertEquals(clientDtoData().getName(), result.getName());
    }

    @Test
    void testFindAll() {
        List<ClientDto> result = clientService.findAll();
        Assertions.assertNotNull(List.of(clientDtoData()));
    }

    private ClientDto clientDtoData() {

        ClientDto clientDto = new ClientDto();
        clientDto.setClientId("1");
        clientDto.setName("Name");
        clientDto.setEmail("email@gmail.com");
        clientDto.setMobilePhone("789564123");

        return clientDto;
    }

    private Client clientData() {

        Client client = new Client();
        client.setClientId("1");
        client.setName("Name");
        client.setEmail("email@gmail.com");
        client.setMobilePhone("789564123");

        return client;


    }
}