package com.viswa.springsecdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/balanceDetails")
    public String getBalanaceDetails() {
        return "Here are the Balance Details from DB";
    }
}
