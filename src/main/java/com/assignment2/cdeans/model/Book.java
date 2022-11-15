package com.assignment2.cdeans.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="BOOK")
@NoArgsConstructor
public class Book {
    public Book(String bookTitle, String price) {
        this.bookTitle = bookTitle;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOOK_ID")
    private Integer bookId;

    @Column(name="BOOK_TITLE")
    private String bookTitle;

    @Column(name="BOOK_PRICE")
    private String price;
}
