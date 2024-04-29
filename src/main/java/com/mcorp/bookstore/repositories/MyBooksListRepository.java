package com.mcorp.bookstore.repositories;

import com.mcorp.bookstore.models.MyBooksList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBooksListRepository extends JpaRepository<MyBooksList, Integer> {

}
