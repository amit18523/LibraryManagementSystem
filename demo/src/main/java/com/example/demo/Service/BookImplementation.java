package com.example.demo.Service;

import com.example.demo.Model.Book;
import com.example.demo.Repositry.AuthRepo;
import com.example.demo.Repositry.BookRepo;
import com.example.demo.Repositry.CateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class BookImplementation implements BookInterface{

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthRepo authRepo;

    @Autowired
    private CateRepo cateRepo;
    @Override
    public Book createBook(Book book) {
        Random r = new Random();
        Long val = Long.valueOf(Integer.hashCode(r.nextInt()));
        val = Math.abs(val % 10000);
        book.setBookId(val);
        return this.bookRepo.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Optional<Book> bookObj = this.bookRepo.findById(book.getBookId());
        if(bookObj.isPresent()){
            Book updatedBook = bookObj.get();
               updatedBook.setPrice(book.getPrice());
            return this.bookRepo.save(updatedBook);
        } else {
            throw new RuntimeException("Book does not exist");
        }
    }

    @Override
    public List<Book> getAllBook() {
        return this.bookRepo.findAll();
    }

    @Override
    public Book getBookById(long id) {
        Optional<Book> book = this.bookRepo.findById(id);
        if(book.isPresent()){
            return book.get();
        } else{
            throw new RuntimeException("Book does not exist");
        }
    }

//    @Override
//    public Book assigAuthtoBook(Long bookId, Long authId) {
//
//            Set<Author> authorSet = null;
//            Book book = bookRepo.findById(bookId).get();
//            Author Auth = authRepo.findById(authId).get();
//            authorSet =  book.getAuthors();
//            authorSet.add(Auth);
//            book.setAuthors(authorSet);
//            return bookRepo.save(book);
//        }

    @Override
    public void deleteBook(long id) {
        Optional<Book> book = this.bookRepo.findById(id);
        if(book.isPresent()){
            this.bookRepo.deleteById(id);
        } else {
            throw new RuntimeException("Book does not exist");
        }
    }

    public BookRepo getBookRepo() {
        return bookRepo;
    }

    public void setBookRepo(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
}
