package com.viswa.springsecdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("/contactDetails")
    public String getContactDetails() {
        return "Here are the Contact Details from DB";
    }
}
