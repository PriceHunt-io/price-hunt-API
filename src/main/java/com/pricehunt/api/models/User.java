package com.pricehunt.api.models;

import com.pricehunt.api.enums.Category;
import com.pricehunt.api.enums.SourcePlatform;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table (name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private SourcePlatform plataform;

    @NotBlank
    private String platformUserId;

    @ElementCollection(targetClass = Category.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_interests", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "interest")
    private List<Category> interests;
}
