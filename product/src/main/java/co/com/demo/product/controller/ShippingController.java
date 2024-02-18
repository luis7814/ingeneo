package co.com.demo.product.controller;

import co.com.demo.product.object.ShippingDto;
import co.com.demo.product.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping("/shipping")
    public ResponseEntity<ShippingDto> save(@RequestBody ShippingDto shippingDto) {
        return new ResponseEntity<>(shippingService.save(shippingDto), HttpStatus.OK);
    }

    @PutMapping("/shipping")
    public ResponseEntity<ShippingDto> update(@RequestBody ShippingDto shippingDto) {
        return new ResponseEntity<>(shippingService.update(shippingDto), HttpStatus.OK);
    }

    @GetMapping("/shipping/{id}")
    public ResponseEntity<ShippingDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(shippingService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/shipping")
    public ResponseEntity<List<ShippingDto>> findAll() {
        return new ResponseEntity<>(shippingService.findAll(), HttpStatus.OK);
    }

}
