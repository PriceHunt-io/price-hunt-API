package com.pricehunt.api.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateValidationDTO(UUID productId, UUID storeId, double price, String url, String platformUserId) {
}
