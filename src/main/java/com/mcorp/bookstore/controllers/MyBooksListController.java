package com.mcorp.bookstore.controllers;

import com.mcorp.bookstore.services.MyBooksListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBooksListController {

    @Autowired
    MyBooksListService myBooksListService;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        myBooksListService.deleteMyBook(id);
        return "redirect:/my_books";
    }

}
