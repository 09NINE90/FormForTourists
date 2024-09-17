package com.grandtour.formfortourists.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
    private String name;
    private String lastName;
    private String patronymic;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private String roles;
}
