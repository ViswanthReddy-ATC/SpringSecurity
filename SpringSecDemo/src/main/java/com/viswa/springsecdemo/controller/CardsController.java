package com.viswa.springsecdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping("/cardDetails")
    public String getCardDetails() {
        return "Here are the Card Details from DB";
    }
}
