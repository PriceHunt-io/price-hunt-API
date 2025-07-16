package com.pricehunt.api.services;

import com.pricehunt.api.dtos.CreateProductDTO;
import com.pricehunt.api.exceptions.NotFoundException;
import com.pricehunt.api.models.Product;
import com.pricehunt.api.repositorys.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public Product create(CreateProductDTO dto){
        Product product = new Product();
        product.setCode(dto.code());
        product.setBrand(dto.brand());
        product.setModel(dto.model());
        product.setDescription(dto.description());
        product.setImgUrl(dto.imgUrl());
        return repository.save(product);
    }

    public Product findById(UUID id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public boolean existsById(UUID id){
        return repository.existsById(id);
    }

}

