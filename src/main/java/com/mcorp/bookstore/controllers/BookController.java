package com.mcorp.bookstore.controllers;

import com.mcorp.bookstore.models.Book;
import com.mcorp.bookstore.models.MyBooksList;
import com.mcorp.bookstore.services.BookService;
import com.mcorp.bookstore.services.MyBooksListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MyBooksListService booksListService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/add_book")
    public String newBook(){
        return "addBook";
    }

    @GetMapping("/all_books")
    public ModelAndView allBooks(){
        List<Book> list = bookService.getAllBooks();
        return new ModelAndView("allBooks", "book", list);
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book b){
        bookService.saveBook(b);
        return "redirect:/all_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBooksList>list = booksListService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @RequestMapping("/myBooks/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b = bookService.getBookById(id);
        MyBooksList mb = new MyBooksList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        booksListService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book b = bookService.getBookById(id);
        model.addAttribute("book", b);
        return "editBook";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteById(id);
        return "redirect:/all_books";
    }
}
