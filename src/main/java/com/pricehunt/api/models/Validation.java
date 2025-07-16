package com.pricehunt.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table

public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @NotEmpty
    private Product product;
    @NotEmpty
    @ManyToOne
    private Store store;
    @NotEmpty
    private double price;

    @NotEmpty
    private String url;

    @NotEmpty
    private boolean isValid;

    @ManyToOne
    private User UserRequester;
}
