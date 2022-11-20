package com.assignment2.cdeans.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment2.cdeans.model.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer> {
  List<Book> findAllByOrderByBookTitle();
  List<Book> findAllByOrderByPriceAsc();
  List<Book> findByBookTitleContainingAndBookTitleContaining(String javaString, String introductionString);
  List<Book> findByBookTitleNotLike(String javaString);
  List<Book> findByBookTitleNotLikeAndBookTitleContaining(String javaString, String introductionString);
}
