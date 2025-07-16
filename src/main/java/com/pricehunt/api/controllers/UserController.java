package com.pricehunt.api.controllers;

import com.pricehunt.api.dtos.CreateUserDTO;
import com.pricehunt.api.models.User;
import com.pricehunt.api.services.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public User findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody CreateUserDTO dto){
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
