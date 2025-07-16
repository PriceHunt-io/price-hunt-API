package com.pricehunt.api.controllers;


import com.pricehunt.api.dtos.CreateStoreDTO;
import com.pricehunt.api.models.Store;
import com.pricehunt.api.services.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService service;

    public StoreController(StoreService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public Store findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Store> create(CreateStoreDTO dto){
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
