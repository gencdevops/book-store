package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Order;
import com.example.bookstore.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final BookService bookService;
    private final OrderRepository orderRepository;
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }

    private  List<Optional<Book>> bookIdToBookList(List<Integer> bookIdList) {
        return bookIdList.stream()
                .map(bookService::findBookById)
                .collect(Collectors.toList());
    }

    private Double getBooksTotalPriceById(List<Optional<Book>> bookList) {
        return bookList.stream()
                .map(optionalBook -> optionalBook.map(Book::getPrice).orElse(0.0))
                .reduce(0.0, Double::sum);
    }

    public Order putAnOrder(List<Integer> bookIdList, String userName) {
       List<Optional<Book>> bookList = bookIdToBookList(bookIdList);
       Double totalPrice =getBooksTotalPriceById(bookList);

       Order order = Order.builder()
               .bookList(bookIdList)
               .totalPrice(totalPrice)
               .userName(userName)
               .build();

       return orderRepository.save(order);
    }

}
