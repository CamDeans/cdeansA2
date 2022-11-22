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
    
    /**
     * inject repositories for authorRepo
     * import AuthorRepo
     */
    AuthorRepo authorRepo;
    /**
     * inject repositories for bookRepo
     * import AuthorRepo
     */
    BookRepo bookRepo;
    
    
    /**
     * @param authorRepo
     * @param bookRepo
     * Autowire the indivdual dependenicies for both repos
     */
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
    /*
    * GetMapping/ PostMapping starts
    * use the PostMapping() method to POST data for author found in MainController, stored in H2 DB
    * use the GetMapping() method to search MainController for author data
    */

    /**
     * @param model
     * @return
     * generate @GetMapping for authorPage using the getData & findAll method()
     * pass all author data to authorPage by use of the author.addAttribute() method
     */
    @GetMapping("/authorPage")
    public String getData(Model model) {
        List<Author> authorList = (List<Author>)authorRepo.findAll();
        model.addAttribute("authorList", authorList);

        return "authorPage";
    }

    
    /**
     * @param model
     * @return
     * generate @GetMapping for bookPage using the getData() & findAll() method
     * pass all book data to authorPage by use of the model.addAtrribute() method
     */
    @GetMapping("/bookPage")
    public String getData1(Model model) {
        List<Book> bookList = (List<Book>)bookRepo.findAll();
        model.addAttribute("bookList", bookList);

        return "bookPage";
    }

    /**
     * @param model
     * @return
     * order authors by last name in ascending order using the findAllByOrderBy() method
     * add authors to dynamic page by use of the model.addAttribute() method
     */
    @PostMapping("/orderByLastNameAsc")
    public String findAllByOrderByLastNameAsc(Model model) {
        List<Author> authors = authorRepo.findAllByOrderByLastNameAsc();
        model.addAttribute("authorList", authors);

        return "authorPage";
    }

    /**
     * @param model
     * @return
     * order authors by first name in descending order using the findAllByOrderBy() method
     * add authors to dynamic page by use of the model.addAttribute() method
     */
    @PostMapping("/orderByFirstNameDesc")
    public String findAllByOrderByFirstNameDesc(Model model) {
        List<Author> authors = authorRepo.findAllByOrderByFirstNameDesc();
        model.addAttribute("authorList", authors);

        return "authorPage";
    }

    /**
     * @param lastName
     * @param firstName
     * @param model
     * @return
     * find authors by first or last name using the findBy() method
     * add authors first or last name to dynamic page by use of the model.addAttribute() method
     */
    @PostMapping("/findLastOrFirst")
    public String findByLastNameIgnoreCaseOrFirstNameIgnoreCase(@RequestParam String lastName, String firstName, Model model) {
        List<Author> authors = authorRepo.findByLastNameIgnoreCaseOrFirstNameIgnoreCase(lastName, firstName);
        model.addAttribute("authorList", authors);

        return "authorPage";
    }

    /**
     * @param prefixString
     * @param model
     * @return
     * find authors by last name that start with any given letter by passing a prefixString to the findBy() method
     * add authors to dynamic page by use of the model.addAttribute() method
     */
    @PostMapping("/findByLastNameStartingWith")
    public String findByLastNameStartingWithIgnoreCase(@RequestParam String prefixString, Model model) {
        List<Author> authors = authorRepo.findByLastNameStartingWithIgnoreCase(prefixString.toUpperCase());
        model.addAttribute("authorList", authors);

        return "authorPage";
    }

    /**
     * @param infixString
     * @param model
     * @return
     * find authors by last name that contain any given string of letters by passing a infixString to the findByContaining() method
     * add authors to dynamic page by use of the model.addAttribute() method
     */
    @PostMapping("/findByLastNameContaining")
    public String findByLastNameContainingIgnoreCase(@RequestParam String infixString, Model model) {
        List<Author> authors = authorRepo.findByLastNameContainingIgnoreCase(infixString);
        model.addAttribute("authorList", authors);

        return "authorPage";
    }

    /**
     * @param model
     * @return
     * order books by title using the findAllByOrderBy() method
     * add book titles to dynamic page by use of the model.addAttribute() method
     */
    @PostMapping("/orderByBookTitle")
    public String findAllByOrderByBookTitle(Model model) {
        List<Book> books = bookRepo.findAllByOrderByBookTitle();
        model.addAttribute("bookList", books);

        return "bookPage";
    }

    /**
     * @param model
     * @return
     * order books by price using the findAllByOrderBy() method
     * add books price to dynamic page by use of the model.addAttribute() method
     */
    @PostMapping("/orderByPrice")
    public String findAllByOrderByPriceAsc(Model model) {
        List<Book> books = bookRepo.findAllByOrderByPriceAsc();
        model.addAttribute("bookList", books);

        return "bookPage";
    }

    /**
     * @param model
     * @return
     * find books by title that contain javaString or introductionString by passing both parameters to the findByContaining() method
     * add book titles to dynamic page by use of the model.addAttribute() method
     */
    @PostMapping("/findByBookTitleContaining")
    public String findByBookTitleContainingAndBookTitleContaining(Model model) {
        String javaString = "Java";
        String introductionString = "Introduction";
        List<Book> books = bookRepo.findByBookTitleContainingAndBookTitleContaining(javaString, introductionString);
        model.addAttribute("bookList", books);

        return "bookPage";
    }

    /**
     * @param model
     * @return
     * find books that do not contain "Java", but do contain "Intruction" in the title by passing 2 strings to the findByNotLikeContaining() method
     * add book titles to dynamic page by use of the model.addAttribute() method
     */
    @PostMapping("/findByBookTitleNotLikeAndContaining")
    public String findByBookTitleNotLikeAndBookTitleContaining(Model model) {
        String javaString = "%Java%";
        String introductionString = "Introduction";
        List<Book> books = bookRepo.findByBookTitleNotLikeAndBookTitleContaining(javaString, introductionString);
        model.addAttribute("bookList", books);

        return "bookPage";
    }

    /**
     * @param model
     * @return
     * find book titles that do not contain "Java" in the title by passing javaStrings to the findByNotLike() method
     * add book titles to dynamic page by use of the model.addAttribute() method
     */
    @PostMapping("/findByBookTitleNotLike")
    public String findByBookTitleNotLike(Model model) {
        String javaString = "%Java%";
        List<Book> books = bookRepo.findByBookTitleNotLike(javaString);
        model.addAttribute("bookList", books);

        return "bookPage";
    }
}