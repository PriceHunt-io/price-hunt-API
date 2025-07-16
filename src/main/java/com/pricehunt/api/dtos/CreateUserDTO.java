package com.pricehunt.api.dtos;

import com.pricehunt.api.enums.Category;
import com.pricehunt.api.enums.SourcePlatform;

import java.util.List;

public record CreateUserDTO(String name, SourcePlatform platform, String platformUserId, List<Category> interests) {
}
