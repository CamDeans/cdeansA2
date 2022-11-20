package com.assignment2.cdeans.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment2.cdeans.model.Author;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Integer> {
    /*
     * Find by first/last name and order
     * Opted to use Ascending for last ordering 
     * Opted to use Descending for first name ordering
     */
    List<Author> findAllByOrderByLastNameAsc();
    List<Author> findAllByOrderByFirstNameDesc();

    /*
     * List by using the 
     * findByLastName() method 
     * findByFirstName() method
     * findByLastnameStartingWith() method using prefix to pass data, add to H2 table with new @Column
     * findByLastNameContaining() method using infix to pass data, add to H2 table with new @Column
     * and pass String value
     */
    List<Author> findByLastNameOrFirstName(String lastName, String firstName);
    List<Author> findByLastNameStartingWith(String prefixString);
    List<Author> findByLastNameContainingIgnoreCase(String infixString);
}
