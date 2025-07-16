package com.pricehunt.api.services;

import com.pricehunt.api.dtos.CreatePriceHistoryDTO;
import com.pricehunt.api.exceptions.NotFoundException;
import com.pricehunt.api.models.PriceHistory;
import com.pricehunt.api.repositorys.PriceHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PriceHistoryService {
    private final PriceHistoryRepository repository;
    private final ProductService productService;
    private final StoreService storeService;

    public PriceHistoryService(PriceHistoryRepository repository, ProductService productService, StoreService storeService) {
        this.repository = repository;
        this.productService = productService;
        this.storeService = storeService;
    }

    public PriceHistory create(CreatePriceHistoryDTO dto){
        PriceHistory priceHistory = new PriceHistory();
        priceHistory.setPrice(dto.price());
        priceHistory.setUrl(dto.url());
        priceHistory.setStore(storeService.findById(dto.storeId()));
        priceHistory.setProduct(productService.findById(dto.productId()));
        return repository.save(priceHistory);
    }

    public PriceHistory findById(UUID id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public boolean existsById(UUID id){
        return repository.existsById(id);
    }

}
