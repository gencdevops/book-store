package com.example.bookstore.controller;

import com.example.bookstore.dto.BookOrderRequest;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Order;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/bookstore")
public class BookStoreController {
    private final OrderService orderService;
    private final BookService bookService;

    public BookStoreController(OrderService orderService, BookService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
    return ResponseEntity.ok( bookList);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orderList = orderService.getAllOrders();
        return ResponseEntity.ok( orderList);
    }

    @PostMapping
    public ResponseEntity<Order> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest) {
    Order order = orderService.putAnOrder(bookOrderRequest.getBookIdList(),bookOrderRequest.getUserName());

    return ResponseEntity.ok(order);
    }
}
