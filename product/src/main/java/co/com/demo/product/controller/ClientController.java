package co.com.demo.product.controller;

import co.com.demo.product.object.ClientDto;
import co.com.demo.product.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/client")
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto) {
        return new ResponseEntity<>(clientService.save(clientDto), HttpStatus.OK);
    }

    @PutMapping("/client")
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto clientDto) {
        return new ResponseEntity<>(clientService.update(clientDto), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/client")
    public ResponseEntity<List<ClientDto>> findAll() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

}
