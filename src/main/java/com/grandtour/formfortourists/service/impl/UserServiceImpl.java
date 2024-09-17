package com.grandtour.formfortourists.service.impl;

import com.grandtour.formfortourists.dto.UserDTO;
import com.grandtour.formfortourists.entity.UserEntity;
import com.grandtour.formfortourists.mapper.UserMapper;
import com.grandtour.formfortourists.repository.UserRepository;
import com.grandtour.formfortourists.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    final
    UserRepository userRepository;
    final UserMapper mapper;
    final PasswordEncoder encoder;


    public UserServiceImpl(UserRepository userRepository, UserMapper mapper, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    public void saveUser(UserDTO user) {
        UserEntity userEntity =  mapper.convertToEntity(user);
        userEntity.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(UUID uuid) {
        return userRepository.findById(uuid).orElse(null);
    }
}
