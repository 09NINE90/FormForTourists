package com.grandtour.formfortourists.api;

import com.grandtour.formfortourists.dto.CustomUserDetails;
import com.grandtour.formfortourists.entity.ApplicationEntity;
import com.grandtour.formfortourists.entity.*;
import com.grandtour.formfortourists.entity.enumeration.MailType;
import com.grandtour.formfortourists.service.ApplicationService;
import com.grandtour.formfortourists.service.MailService;
import com.grandtour.formfortourists.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/form")
public class ApplicationApi {

    final
    ApplicationService applicationService;
    final
    UserService userService;

    final MailService mailService;

    public ApplicationApi(ApplicationService applicationService, UserService userService, MailService mailService) {
        this.applicationService = applicationService;
        this.userService = userService;
        this.mailService = mailService;
    }

    @PostMapping(value = "/sendRequest",consumes = "application/json")
    public ResponseEntity<?> sendRequest(Authentication authentication, @RequestBody ApplicationEntity application){
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        UserEntity user = userService.getUserById(userDetails.getId());
        application.setUserEntity(user);
        try{
            applicationService.saveApplication(application);
            mailService.sendMail(user, application, MailType.REQUEST, new Properties());
            mailService.sendMail(user, application, MailType.REQUEST_INFO, new Properties());
            return ResponseEntity.status(200).build();
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/getAllRequest")
    public List<ApplicationEntity> getAllRequest(){
        return applicationService.getAllRequest();
    }
}
