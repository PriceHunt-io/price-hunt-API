package com.pricehunt.api.services;

import com.pricehunt.api.dtos.CreateStoreDTO;
import com.pricehunt.api.exceptions.NotFoundException;
import com.pricehunt.api.models.Store;
import com.pricehunt.api.repositorys.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StoreService {

    private final StoreRepository repository;

    public StoreService(StoreRepository repository) {
        this.repository = repository;
    }

    public Store create(CreateStoreDTO dto){
        Store store = new Store();
        store.setUrl(dto.url());
        store.setName(dto.name());
        return repository.save(store);
    }

    public Store findById(UUID id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public boolean existsById(UUID id){
        return repository.existsById(id);
    }

}

