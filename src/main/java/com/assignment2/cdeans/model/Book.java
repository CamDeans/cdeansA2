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
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data
@Table(name="BOOK")
/**
 * implement @NoArgsContructor for use of AUTHOR_ID withitn H2 DB and program
 */
@NoArgsConstructor
public class Book {
    /**
     * @param bookTitle
     * @param price
     * Generate contructor for book title and price
     */
    public Book(String bookTitle, Double price) {
        this.bookTitle = bookTitle;
        this.price = price;
    }

    /**
     * implement @Id for primary key of an intentity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOOK_ID")
    private Integer bookId;

    /**
     * specify column in H2 DB for booktitle type String
     */
    @Column(name="BOOK_TITLE")
    private String bookTitle;

    /**
     * specify column in H2 DB for price type Double
     */
    @Column(name="BOOK_PRICE")
    private Double price;
}
