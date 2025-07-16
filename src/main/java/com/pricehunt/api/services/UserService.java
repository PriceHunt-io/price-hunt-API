package com.pricehunt.api.services;

import com.pricehunt.api.dtos.CreateUserDTO;
import com.pricehunt.api.exceptions.NotFoundException;
import com.pricehunt.api.models.User;
import com.pricehunt.api.repositorys.UserRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(CreateUserDTO dto){
        User user = new User();
        user.setPlatformUserId(dto.platformUserId());
        user.setName(dto.name());
        user.setPlataform(dto.platform());
        user.setInterests(dto.interests());
        return repository.save(user);
    }

    public User findById(UUID id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public User findByPlatformUserId(String id){
        return repository.findByPlatformUserId(id);
    }
    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public boolean existsById(UUID id){
        return repository.existsById(id);
    }



}
