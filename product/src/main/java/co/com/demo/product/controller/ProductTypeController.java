package co.com.demo.product.controller;

import co.com.demo.product.object.ProductTypeDto;
import co.com.demo.product.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping("/product-type")
    public ResponseEntity<ProductTypeDto> save(@RequestBody ProductTypeDto productTypeDto) {
        return new ResponseEntity<>(productTypeService.save(productTypeDto), HttpStatus.OK);
    }

    @PutMapping("/product-type")
    public ResponseEntity<ProductTypeDto> update(@RequestBody ProductTypeDto productTypeDto) {
        return new ResponseEntity<>(productTypeService.update(productTypeDto), HttpStatus.OK);
    }

    @GetMapping("/product-type/{id}")
    public ResponseEntity<ProductTypeDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(productTypeService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/product-type")
    public ResponseEntity<List<ProductTypeDto>> findAll() {
        return new ResponseEntity<>(productTypeService.findAll(), HttpStatus.OK);
    }

}
