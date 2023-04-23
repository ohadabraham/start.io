package com.start.io.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/start/io/listings")
public class AppController {

    @GetMapping("/health")
    public String health() {
        return "{\"status\":\"UP\"}";
    }
}
