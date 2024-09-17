package com.grandtour.formfortourists.api;

import com.grandtour.formfortourists.dto.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class FormApi {

    @GetMapping("/getFormPage")
    public String getFormPage(Authentication authentication){
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        if (userDetails.getRole().equals("ROLE_USER")){
            return "request-form";
        }
        return "redirect:/form/getRequestsPage";
    }

}
