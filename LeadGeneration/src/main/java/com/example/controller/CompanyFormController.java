package com.example.controller;

import com.example.CompanyForm;
import com.example.service.CompanyFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CompanyFormController {

    @Autowired
    private CompanyFormService companyFormService;

    @GetMapping("/companyform")
    public String showForm(Model model) {
        return "company-add-post";
    }
    
    @PostMapping("/companyform")
    public String submitForm(@RequestParam String title,
                             @RequestParam String description,
                             @RequestParam String department,
                             @RequestParam MultipartFile image, // Change to MultipartFile
                             @RequestParam String amount,
                             Model model) {
    	
        CompanyForm post = new CompanyForm();
        post.setTitle(title);
        post.setDescription(description);
        post.setDepartment(department);
        post.setAmount(amount);

        if (!image.isEmpty()) {
            // Upload the file and get the filename
			String fileName = new String();
			post.setImage(fileName); // Save only the filename in your entity
        }

        companyFormService.savePost(post);
        return "redirect:/success";
    }
}
