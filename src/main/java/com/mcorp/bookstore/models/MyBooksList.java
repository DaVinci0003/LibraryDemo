package com.mcorp.bookstore.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MyBooks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBooksList {

    @Id
    private int id;
    private String name;
    private String author;
    private String price;
}
