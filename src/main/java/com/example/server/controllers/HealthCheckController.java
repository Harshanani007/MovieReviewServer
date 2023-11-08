package com.example.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@ResponseBody
public class HealthCheckController {

    @GetMapping("/")
    public ResponseEntity<String> healthCheck1() {
        // You can add your custom checks here (e.g., check the database)
        // If everything is healthy, return a 200 OK response
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/healthyz")
    public ResponseEntity<String> healthCheck2() {
        // You can add your custom checks here (e.g., check the database)
        // If everything is healthy, return a 200 OK response
        return ResponseEntity.ok("OK");
    }
}
