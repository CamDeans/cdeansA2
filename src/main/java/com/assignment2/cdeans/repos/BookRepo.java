package com.assignment2.cdeans.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment2.cdeans.model.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer> {
  /**
   * @return
   * find all book titles and list them in bookPage
   */
  List<Book> findAllByOrderByBookTitle();
  
  /**
   * @return
   * find all prices in MainController and list them in bookPage
   */
  List<Book> findAllByOrderByPriceAsc();
  
  /**
   * @param javaString
   * @param introductionString
   * @return
   * find by book title containing both strings passed by the program
   */
  List<Book> findByBookTitleContainingAndBookTitleContaining(String javaString, String introductionString);
 
  /**
   * @param javaString
   * @return
   * find by book title not containing java by passing javString not from the 
   * user but the program
   */
  List<Book> findByBookTitleNotLike(String javaString);
  
  /**
   * @param javaString
   * @param introductionString
   * @return
   * find by book title not containing java, but is containing introduciton by 
   * passing javString and introductionString not from the user but the program
   */
  List<Book> findByBookTitleNotLikeAndBookTitleContaining(String javaString, String introductionString);
}
