package com.pricehunt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table

public class PriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotEmpty
    @ManyToOne
    private Product product;

    @NotEmpty
    private double price;

    @NotBlank
    private String url;

    @NotEmpty
    private LocalDateTime dateTime;

    @ManyToOne
    private Store store;
}
