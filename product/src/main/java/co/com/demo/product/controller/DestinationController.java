package co.com.demo.product.controller;

import co.com.demo.product.object.DestinationDto;
import co.com.demo.product.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @PostMapping("/destination")
    public ResponseEntity<DestinationDto> save(@RequestBody DestinationDto destinationDto) {
        return new ResponseEntity<>(destinationService.save(destinationDto), HttpStatus.OK);
    }

    @PutMapping("/destination")
    public ResponseEntity<DestinationDto> update(@RequestBody DestinationDto destinationDto) {
        return new ResponseEntity<>(destinationService.update(destinationDto), HttpStatus.OK);
    }

    @GetMapping("/destination/{id}")
    public ResponseEntity<DestinationDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(destinationService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/destination")
    public ResponseEntity<List<DestinationDto>> findAll() {
        return new ResponseEntity<>(destinationService.findAll(), HttpStatus.OK);
    }

}
