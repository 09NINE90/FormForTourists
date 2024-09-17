package com.grandtour.formfortourists.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class RequestsPageApi {
    @GetMapping("/getRequestsPage")
    public String getRequestsPage(){
        return "requests";
    }
}
