package com.assignment2.cdeans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    Author dave = authorRepo.save(new Author("Dave", "Adams"));
    Author david = authorRepo.save(new Author("David", "Grimms"));
    Author dan = authorRepo.save(new Author("Dan", "Gold"));

    // assign books to the author starts
    cameron.getBookList().add(bookRepo.save(new Book("Clean Code", 47.50)));
    leah.getBookList().add(bookRepo.save(new Book("Head First Java", 71.25)));
    londyn.getBookList().add(bookRepo.save(new Book("Effective Java", 39.50)));
    brooklynn.getBookList().add(bookRepo.save(new Book("Java The Complete Reference", 69.19)));
    brooklynn2.getBookList().add(bookRepo.save(new Book("Java For Dummies", 89.89)));
    brooklynn3.getBookList().add(bookRepo.save(new Book("Introduction to Java", 39.29)));
    brooklynn4.getBookList().add(bookRepo.save(new Book("Introduciton to Python", 49.99)));
    dave.getBookList().add(bookRepo.save(new Book("Introduction to C#", 89.89)));
    david.getBookList().add(bookRepo.save(new Book("Introduction to C++", 39.29)));
    dan.getBookList().add(bookRepo.save(new Book("Introduciton to Javascript", 49.99)));

    // save books to the auhtor starts by passing author objects
    authorRepo.save(cameron);
    authorRepo.save(leah);
    authorRepo.save(londyn);
    authorRepo.save(brooklynn);
    authorRepo.save(brooklynn2);
    authorRepo.save(brooklynn3);
    authorRepo.save(brooklynn4);
    authorRepo.save(dave);
    authorRepo.save(david);
    authorRepo.save(dan);    
    }

    // generate @GetMapping starts
    @GetMapping("/data")
    public String getData(Model model) {
        List<Author> authorList = (List<Author>)authorRepo.findAll();
        List<Book> bookList = (List<Book>)bookRepo.findAll();

        model.addAttribute("bookList", bookList);
        model.addAttribute("authorList", authorList);

        return "authorPage";
    }

    /*
     * order bookTitle by using the findAllByOrderBy method and pass model
     * order by book title
     */
    @PostMapping("/orderByBookTitle")
    public String findAllByOrderByBookTitle(Model model) {
        List<Book> books = bookRepo.findAllByOrderByBookTitle();
        model.addAttribute("bookList", books);

        return "authorPage";
    }

       /*
     * order bookTitle by using the findAllByOrderBy method and pass model
     * order by book title
     */
    @PostMapping("/orderByPrice")
    public String findAllByOrderByPriceAsc(Model model) {
        List<Book> books = bookRepo.findAllByOrderByPriceAsc();
        model.addAttribute("bookList", books);

        return "authorPage";
    }

      /*
     * order bookTitle by using the findAllByOrderBy method and pass model
     * order by book title
     */
    @PostMapping("/orderByLastNameAsc")
    public String findAllByOrderByLastNameAsc(Model model) {
        List<Author> authors = authorRepo.findAllByOrderByLastNameAsc();
        model.addAttribute("authorList", authors);

        return "authorPage";
    }

    /*
     * order bookTitle by using the findAllByOrderBy method and pass model
     * order by book title
     */
    @PostMapping("/orderByFirstNameDesc")
    public String findAllByOrderByFirstNameDesc(Model model) {
        List<Author> authors = authorRepo.findAllByOrderByFirstNameDesc();
        model.addAttribute("authorList", authors);

        return "authorPage";
    }

    /*
     * pass Introduction as a string by use of @PostMapping and findByBookTitleContining method and model
     */
    @PostMapping("/findByBookTitleContaining")
    public String findByBookTitleContainingAndBookTitleContaining(Model model) {
        String javaString = "Java";
        String introductionString = "Introduction";
        List<Book> books = bookRepo.findByBookTitleContainingAndBookTitleContaining(javaString, introductionString);
        model.addAttribute("bookList", books);

        return "authorPage";
    }

    /*
     * pass Introduction as a string by use of @PostMapping and findByBookTitleContining method and model
     */
    @PostMapping("/findByBookTitleNotLikeAndContaining")
    public String findByBookTitleNotLikeAndBookTitleContaining(Model model) {
        String javaString = "%Java%";
        String introductionString = "Introduction";
        List<Book> books = bookRepo.findByBookTitleNotLikeAndBookTitleContaining(javaString, introductionString);
        model.addAttribute("bookList", books);

        return "authorPage";
    }

    /*
     * pass Introduction as a string by use of @PostMapping and findByBookTitleContining method and model
     */
    @PostMapping("/findByBookTitleNotLike")
    public String findByBookTitleNotLike(Model model) {
        String javaString = "%Java%";
        List<Book> books = bookRepo.findByBookTitleNotLike(javaString);
        model.addAttribute("bookList", books);

        return "authorPage";
    }

     /*
     * pass lastName by use of @PostMapping and @RequestParam by passing it lastName and model
     */
    @PostMapping("/findLastOrFirst")
    public String findByLastNameOrFirstName(@RequestParam String lastName, String firstName, Model model) {
        List<Author> authors = authorRepo.findByLastNameOrFirstName(lastName, firstName);
        model.addAttribute("authorList", authors);

        return "authorPage";
    }

    /*
     * pass lastName by use of @PostMapping and @RequestParam by passing it lastName and model
     */
    @PostMapping("/findByLastNameStartingWith")
    public String findByLastNameStartingWith(@RequestParam String prefixString, Model model) {
        List<Author> authors = authorRepo.findByLastNameStartingWith(prefixString.toUpperCase());
        model.addAttribute("authorList", authors);

        return "authorPage";
    }

    /*
     * pass lastName by use of @PostMapping and @RequestParam by passing it lastName and model
     */
    @PostMapping("/findByLastNameContaining")
    public String findByLastNameContainingIgnoreCase(@RequestParam String infixString, Model model) {
        List<Author> authors = authorRepo.findByLastNameContainingIgnoreCase(infixString);
        model.addAttribute("authorList", authors);

        return "authorPage";
    }
}