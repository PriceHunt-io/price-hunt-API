package com.pricehunt.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pricehunt.api.models.PriceHistory;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PriceHistoryRepository extends JpaRepository<PriceHistory, UUID> {
}
