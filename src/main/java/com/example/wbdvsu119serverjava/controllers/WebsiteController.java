package com.example.wbdvsu119serverjava.controllers;

import com.example.wbdvsu119serverjava.models.content.Website;
import com.example.wbdvsu119serverjava.repositories.WebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class WebsiteController {
    @Autowired
    WebsiteRepository websiteRepository;
    @GetMapping("/api/websites")
    public List<Website> findAllWebsites() {
        return websiteRepository.findAllWebsites();
    }
}
