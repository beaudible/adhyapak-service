package com.valmiki.adhyapakservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/adhyapak")
public class adhyapakController {
    @GetMapping("/greet")
    ResponseEntity<String> hello() {
        return ResponseEntity.ok("Suprabhat!");
    }
}