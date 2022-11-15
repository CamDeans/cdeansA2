package com.assignment2.cdeans.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="AUTHOR")
@NoArgsConstructor
public class Author {
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName; 
        // instantiate a new array list each time using bookList
        bookList = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AUTHOR_ID")
    private Integer authorId;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    // Define relationship with a list of books, so that one autor can have many books
    @OneToMany
    // Define parent wihtin main class which joins using the author id from the author table
    //
    @JoinColumn(name="AUTHOR_ID")
    List<Book> bookList;
}
