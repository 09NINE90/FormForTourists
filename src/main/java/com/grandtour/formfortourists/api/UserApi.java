package com.grandtour.formfortourists.api;

import com.grandtour.formfortourists.dto.UserDTO;
import com.grandtour.formfortourists.entity.UserEntity;
import com.grandtour.formfortourists.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserApi {
    final
    UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getSignupForm")
    public String createUserPage(Model model){
        model.addAttribute("user",new UserDTO());
        return "signup";
    }

    @PostMapping("/create")
    public String userSave(@ModelAttribute("user") UserDTO user){
        user.setRoles("ROLE_USER");
        userService.saveUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }
}
