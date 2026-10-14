package com.viswa.springsecdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
    @GetMapping("/noticeDetails")
    public String getNoticeDetails() {
        return "Here are the Notice Details from DB";
    }
}
