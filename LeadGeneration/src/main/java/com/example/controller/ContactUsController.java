//package com.example.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.ContactUs;
//import com.example.repository.ContactUsRepository;
//@Controller
//public class ContactUsController {
//	
//	 @Autowired
//	    private ContactUsRepository contactUsRepository;
//
//	 @GetMapping("/contact")
//	 public String showContactForm(Model model) {
//	     // Prepare to show the contact form
//	     return "contact"; // The name of your contact form view
//	 }
//
//	    @PostMapping("/contact")
//	    public String submitContactUsForm(@ModelAttribute ContactUs contactUs) {
//	        // Save the form data to the database
//	        contactUsRepository.save(contactUs);
//	        
//	        // Redirect to the success page
//	        return "redirect:/success";
//	    }
//	}
//
//package com.example.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.ContactUs;
//import com.example.repository.ContactUsRepository;
//
//@RestController // Change from @Controller to @RestController for REST API handling
//public class ContactUsController {
//
//    @Autowired
//    private ContactUsRepository contactUsRepository;
//
//    // Handle GET requests to show the form in a web browser
//    @GetMapping("/api/contact") // Change this URL as needed
//    public List<ContactUs> getAllContactEntries() {
//        return contactUsRepository.findAll(); // Return the list of contacts as JSON
//    }
//
//    // Handle POST request from Postman or other clients sending JSON data
//    @PostMapping("/contact")
//    public ResponseEntity<String> submitContactUsForm(@RequestBody ContactUs contactUs) {
//        // Debugging: print the values received
//        System.out.println("Full Name: " + contactUs.getFullname());
//        System.out.println("Email: " + contactUs.getEmail());
//        System.out.println("Phone Number: " + contactUs.getPhonenumber());
//        System.out.println("Message: " + contactUs.getMessage());
//
//        // Save the form data to the database
//        contactUsRepository.save(contactUs);
//
//        return ResponseEntity.ok("Contact saved successfully!");
//    }
//}
package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.ContactUs;
import com.example.repository.ContactUsRepository;
@Controller
public class ContactUsController {
	
	 @Autowired
	    private ContactUsRepository contactUsRepository;

		
		  @GetMapping("/contact") 
		  public String showContactUsForm(Model model) {
		  model.addAttribute("contactUs", new ContactUs()); 
		  return "index"; // The
		  }
	
	    @PostMapping("/contact")
	    public String submitContactUsForm(@ModelAttribute ContactUs contactUs) {
	        // Save the form data to the database
	        contactUsRepository.save(contactUs);
	        
	        // Redirect to the success page
	        return "redirect:/success";
	    }
	}

