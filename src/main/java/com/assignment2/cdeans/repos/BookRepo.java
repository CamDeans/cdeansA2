package com.assignment2.cdeans.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment2.cdeans.model.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer> {
    
}
