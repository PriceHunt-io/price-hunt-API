package com.pricehunt.api.controllers;

import com.pricehunt.api.dtos.CreatePriceHistoryDTO;
import com.pricehunt.api.models.PriceHistory;
import com.pricehunt.api.services.PriceHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

public class PriceHistoryController {

    private final PriceHistoryService service;

    public PriceHistoryController(PriceHistoryService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public PriceHistory findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<PriceHistory> create(CreatePriceHistoryDTO dto){
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
