package com.booksproject.api.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")

public class LibController {


    @GetMapping
    public ResponseEntity getAllBooks() {
        return ResponseEntity.ok("Deu ok");
    }
}

