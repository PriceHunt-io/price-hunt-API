package com.pricehunt.api.repositorys;

import com.pricehunt.api.models.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ValidationRepository extends JpaRepository<Validation, UUID> {
}
