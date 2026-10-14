package com.viswa.springsecdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/loanDetails")
    public String getLoanDetails() {
        return "Here are the Loan Details from DB";
    }
}
