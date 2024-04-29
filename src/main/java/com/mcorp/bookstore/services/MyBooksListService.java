package com.mcorp.bookstore.services;

import com.mcorp.bookstore.models.Book;
import com.mcorp.bookstore.models.MyBooksList;
import com.mcorp.bookstore.repositories.MyBooksListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBooksListService {

    @Autowired
    private MyBooksListRepository myBooksListRepository;

    public void saveMyBooks(MyBooksList b){
        myBooksListRepository.save(b);
    }

    public List<MyBooksList> getAllMyBooks(){
        return myBooksListRepository.findAll();
    }

    public void deleteMyBook(int id){
        myBooksListRepository.deleteById(id);
    }


}
