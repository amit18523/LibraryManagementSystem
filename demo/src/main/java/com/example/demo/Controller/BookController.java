package com.example.demo.Controller;

import com.example.demo.Model.Book;
import com.example.demo.Service.BookImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookImplementation bookcon;

    @GetMapping("/hi1")
    private String book(){
        return "hi";
    }

    @GetMapping("/book")
    private ResponseEntity<List<Book>> getAllBook(){
        return ResponseEntity.ok().body(this.bookcon.getAllBook());
    }

    @GetMapping("/book/{id}")
    private Book getBook(@PathVariable Long id){
        return this.bookcon.getBookById(id);
    }

    @PostMapping("/createBook")
    private ResponseEntity<Book> saveBook(@RequestBody Book book){
        return ResponseEntity.ok().body(this.bookcon.createBook(book));
    }

    @PutMapping("/book/{bookId}")
    private ResponseEntity<Book> updateBook(@PathVariable long bookId, @RequestBody Book book){
       // book.setBookId(bookId);
        return ResponseEntity.ok().body(this.bookcon.updateBook(book));
    }
//    @PutMapping("/{bookID}/project/{authID}")
//    public Book assignAuthToBook(
//            @PathVariable Long bookId,
//            @PathVariable Long authId
//    ){
//        return bookcon.assigAuthtoBook(bookId, authId);
//    }
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable long id) {
        bookcon.deleteBook(id);
    }
}
