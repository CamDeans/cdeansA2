package com.assignment2.cdeans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.assignment2.cdeans.model.Author;
import com.assignment2.cdeans.model.Book;
import com.assignment2.cdeans.repos.AuthorRepo;
import com.assignment2.cdeans.repos.BookRepo;

@Controller
public class MainController {
    // Inject repositories starts
    AuthorRepo authorRepo;
    BookRepo bookRepo;
    
    // Autowire the indivdual dependenicies
    @Autowired
    public MainController(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;

    // generate an author object starts
    // update using authorRepo.save 
    Author cameron = authorRepo.save(new Author("Cameron", "Deans"));
    Author leah = authorRepo.save(new Author("Leah", "Deans"));
    Author londyn = authorRepo.save(new Author("Londyn", "Deans"));
    Author brooklynn = authorRepo.save(new Author("Brooklynn", "Deans"));
    Author brooklynn2 = authorRepo.save(new Author("Brooklynn", "Beazer"));
    Author brooklynn3 = authorRepo.save(new Author("Brooklynn", "Chase"));
    Author brooklynn4 = authorRepo.save(new Author("Brooklynn", "Ze"));

    // assign books to the author starts
    //cameron.getBookList().add(bookRepo.save(new Book("java", "$2")));
    cameron.getBookList().add(bookRepo.save(new Book("Clean Code", "$47.50")));
    leah.getBookList().add(bookRepo.save(new Book("Head First Java", "$71.25")));
    londyn.getBookList().add(bookRepo.save(new Book("Effective Java", "$39.50")));
    brooklynn.getBookList().add(bookRepo.save(new Book("Java The Complete Reference", "$69.19")));
    brooklynn2.getBookList().add(bookRepo.save(new Book("Java The Complete Reference2", "$269.19")));
    brooklynn3.getBookList().add(bookRepo.save(new Book("Java The Complete Reference3", "$369.19")));
    brooklynn4.getBookList().add(bookRepo.save(new Book("Java The Complete Reference4", "$469.19")));
    
    // save books to the auhtor starts by passing author objects
    authorRepo.save(cameron);
    authorRepo.save(leah);
    authorRepo.save(londyn);
    authorRepo.save(brooklynn);
    authorRepo.save(brooklynn2);
    authorRepo.save(brooklynn3);
    authorRepo.save(brooklynn4);

    }

    // generate @GetMapping starts
    @GetMapping("/data")
    public String getData(Model model) {
        List<Author> authorList = (List<Author>)authorRepo.findAll();
        List<Book> bookList = (List<Book>)bookRepo.findAll();
        List<Author> authorLastNameOrderedList = (List<Author>)authorRepo.findByLastNameOrderByAuthorIdAsc("Deans");
        List<Author> authorFirstNameOrderedList = (List<Author>)authorRepo.findByFirstNameOrderByAuthorIdDesc("Brooklynn");

        model.addAttribute("bookList", bookList);
        model.addAttribute("authorList", authorList);
        model.addAttribute(("authorLastNameOrderedList"), authorLastNameOrderedList);
        model.addAttribute(("authorFirstNameOrderedList"), authorFirstNameOrderedList);

        return "authorPage";
    }
}