package com.example.bookstore.controller;

import com.example.bookstore.model.Order;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/bookstore")
public class BookStoreController {

    @GetMapping
    public ResponseEntity<String> hi() {
        return ResponseEntity.ok("hi");
    }

    @PostMapping
    public ResponseEntity<Order> putAnOrder() {

    }
}
