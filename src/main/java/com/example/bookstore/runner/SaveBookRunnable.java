package com.example.bookstore.runner;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import lombok.EqualsAndHashCode;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SaveBookRunnable implements ApplicationRunner {
    BookRepository bookRepository;

    public SaveBookRunnable(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    Book book1 = Book.builder()
            .name("Yuzuklerin efendisi")
            .author("JRR Tolkien")
            .price(10.0)
            .stock(10)
            .build();
    Book book2 = Book.builder()
            .name("Inception")
            .author("Dan Brown")
            .price(11.1)
            .stock(5)
            .build();

       Book book3 = Book.builder()
            .name("Dinle Küçük Adam")
            .author("Willheim Reich")
            .price(15.70)
            .stock(9)
            .build();

        bookRepository.saveAll(Arrays.asList(book1, book2, book3));

    }
}
