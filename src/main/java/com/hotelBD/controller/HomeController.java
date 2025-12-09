package com.hotelBD.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to PostgreSQL Query Application");
        response.put("status", "running");
        response.put("endpoints", Map.of(
            "getAllUsers", "GET /api/users",
            "getUserById", "GET /api/users/{id}",
            "getUsersByCity", "GET /api/users/city/{city}",
            "searchByName", "GET /api/users/search?name={name}",
            "getUsersByEmailDomain", "GET /api/users/domain/{domain}",
            "createUser", "POST /api/users",
            "deleteUser", "DELETE /api/users/{id}"
        ));
        return response;
    }
}
