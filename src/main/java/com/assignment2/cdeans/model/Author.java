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
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data
@Table(name="AUTHOR")
/**
 * implement @NoArgsContructor for use of AUTHOR_ID withitn H2 DB and program
 */
@NoArgsConstructor
public class Author {
    /**
     * @param firstName
     * @param lastName
     * Generate contructor for first and last name
     */
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName; 
        // instantiate a new array list each time using bookList
        bookList = new ArrayList<>();
    }

    /**
     * implement @Id for primary key of an intentity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AUTHOR_ID")
    private Integer authorId;

    /**
     * specify column in H2 DB for firstName type String
     */
    @Column(name="FIRST_NAME")
    private String firstName;

    /**
     * specify column in H2 DB for lastName type String
     */
    @Column(name="LAST_NAME")
    private String lastName;

    /**
     * implement @OneToMany to define relationship with a list of books, so that one autor can have many books
     */
    @OneToMany
    // Define parent wihtin main class which joins using the author id from the author table
    //
    @JoinColumn(name="AUTHOR_ID")
    List<Book> bookList;
}
