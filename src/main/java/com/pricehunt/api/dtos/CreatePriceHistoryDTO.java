package com.pricehunt.api.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreatePriceHistoryDTO(UUID productId, double price, String url, LocalDateTime dateTime, UUID storeId) {
}
