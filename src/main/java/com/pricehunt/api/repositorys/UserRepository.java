package com.pricehunt.api.repositorys;

import com.pricehunt.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,UUID> {

    public User findByPlatformUserId(String platformUserId);
}
