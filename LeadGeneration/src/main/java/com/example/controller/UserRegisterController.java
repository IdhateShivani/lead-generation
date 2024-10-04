
package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.ContactUs;
import com.example.UserRegister;
import com.example.repository.ContactUsRepository;
import com.example.repository.UserRegisterRepository;

@Controller
public class UserRegisterController {
    
    @Autowired
    private UserRegisterRepository registerRepository;

    // Display the registration form
    @GetMapping("/user-reg") 
    public String showRegisterForm(Model model) {
        model.addAttribute("register", new UserRegister()); // Use 'register' for consistency
        return "user-register"; // Return the view name where the form is located
    }

    // Handle form submission
    @PostMapping("/user-reg")
    public String submitRegisterForm(@ModelAttribute UserRegister register) { // Use 'Register' instead of 'ContactUs'
        // Save the form data to the database
        registerRepository.save(register);
        
        // Redirect to the success page
        return "redirect:/success";
    }
}