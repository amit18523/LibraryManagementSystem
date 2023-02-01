package com.example.demo.Repositry;

import com.example.demo.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
//    default Book findbyName(String name){

}
