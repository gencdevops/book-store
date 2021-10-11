package com.example.bookstore.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table
@ToString
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private Double price;
    private Integer stock;


}
