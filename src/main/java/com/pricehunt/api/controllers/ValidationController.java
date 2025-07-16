package com.pricehunt.api.controllers;

import com.pricehunt.api.dtos.CreateValidationDTO;
import com.pricehunt.api.models.Validation;
import com.pricehunt.api.services.ValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    private final ValidationService service;

    public ValidationController(ValidationService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public Validation findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Validation> create(@RequestBody CreateValidationDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable UUID id){
        if(service.existsById(id)){
            service.deleteById(id);
            return ResponseEntity.ok("Deletado com sucesso");
        }
        return ResponseEntity.notFound().build();
    }



}
