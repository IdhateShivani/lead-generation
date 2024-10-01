package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuperAdminController {

    @GetMapping("/super")
    public String showIndexPage() {
        return "superadmindashboard";  
    }
}
