//package com.grandtour.formfortourists.config;
//
//import com.grandtour.formfortourists.entity.UserEntity;
//import com.grandtour.formfortourists.repository.UserRepository;
//import org.apache.commons.jexl3.JxltEngine;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//    final
//    UserRepository userRepository;
//    final
//    PasswordEncoder encoder;
//    public DataLoader(UserRepository userRepository, PasswordEncoder encoder) {
//        this.userRepository = userRepository;
//        this.encoder = encoder;
//    }
//
//    @java.lang.Override
//    public void run(java.lang.String... args) throws JxltEngine.Exception {
//        UserEntity user = new UserEntity();
//        user.setName("Алексей");
//        user.setLastName("Разумов");
//        user.setPatronymic("Антонович");
//        user.setEmail("raz@ya.ru");
//        user.setPhoneNumber("+7 (999) 99-99-999");
//        user.setRoles("ROLE_ADMIN");
//        user.setPassword(encoder.encode("raz@ya.ru"));
//        userRepository.save(user);
//        System.out.println("Пользователь добавлен!");
//    }
//}