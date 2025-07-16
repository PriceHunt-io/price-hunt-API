package com.pricehunt.api.controllers;

import com.pricehunt.api.dtos.CreateProductDTO;
import com.pricehunt.api.models.Product;
import com.pricehunt.api.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public Product findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Product> create(CreateProductDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable UUID id){
        if(service.existsById(id)){
            service.deleteById(id);
            return ResponseEntity.ok("Deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

}
