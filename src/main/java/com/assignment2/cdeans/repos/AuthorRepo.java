package com.assignment2.cdeans.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment2.cdeans.model.Author;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Integer> {
    /**
     * Find by first/last name and order
     * @return
     * Opted to use Ascending for last ordering 
     */
    List<Author> findAllByOrderByLastNameAsc();

    /**
     * @return
     * Opted to use Descending for first name ordering
     */
    List<Author> findAllByOrderByFirstNameDesc();

    /**
     * @param lastName
     * @param firstName
     * @return
     * findByLastName() or firstName() method and ignore case sensitivity 
     */
    List<Author> findByLastNameIgnoreCaseOrFirstNameIgnoreCase(String lastName, String firstName);
    
    /**
     * @param prefixString
     * @return
     * findByLastnameStartingWith() method using prefix to pass data, add to H2 
     * table with new @Column
     */
    List<Author> findByLastNameStartingWithIgnoreCase(String prefixString);
    
    /**
     * @param infixString
     * @return
     * findByLastNameContaining() method using infix to pass data, add to H2 
     * table with new @Column
     */
    List<Author> findByLastNameContainingIgnoreCase(String infixString);
}
