package com.grandtour.formfortourists.repository;

import com.grandtour.formfortourists.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByEmail(String email);

    Optional<UserEntity> findById(UUID id);

}
