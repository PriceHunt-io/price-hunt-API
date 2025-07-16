package com.pricehunt.api.services;

import com.pricehunt.api.dtos.CreateValidationDTO;
import com.pricehunt.api.exceptions.NotFoundException;
import com.pricehunt.api.models.Validation;
import com.pricehunt.api.repositorys.ValidationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidationService {

    private final ValidationRepository repository;
    private final ProductService productService;

    private final UserService userService;

    private final StoreService storeService;

    public ValidationService(ValidationRepository repository, ProductService productService, UserService userService, StoreService storeService) {
        this.repository = repository;
        this.productService = productService;
        this.userService = userService;
        this.storeService = storeService;
    }

    public Validation create(CreateValidationDTO dto){
        Validation validation = new Validation();
        validation.setUrl(dto.url());
        validation.setProduct(productService.findById(dto.productId()));
        validation.setStore(storeService.findById(dto.storeId()));
        validation.setUserRequester(userService.findByPlatformUserId(dto.platformUserId()));
        // falta o isValid
        return repository.save(validation);
    }

    public Validation findById(UUID id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public boolean existsById(UUID id){
        return repository.existsById(id);
    }

//    public boolean validate(String url){
//
//    }


}
