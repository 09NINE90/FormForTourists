package com.grandtour.formfortourists.service;

import com.grandtour.formfortourists.dto.UserDTO;
import com.grandtour.formfortourists.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    void saveUser(UserDTO user);

    List<UserEntity> getAllUsers();

    UserEntity getUserById(UUID uuid);
}
