package com.example.demo.Service;

import com.example.demo.Model.Author;
import com.example.demo.Repositry.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthImplement implements AuthInterface {

    @Autowired
    private AuthRepo authRepo;

    @Override
    public Author createAuthor(Author author) {

        return this.authRepo.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {

        Optional<Author> authObj = this.authRepo.findById(author.getAuthorId());
        if(authObj.isPresent()){
            Author updatedAuth = authObj.get();
            updatedAuth.setName(author.getName());
            return this.authRepo.save(updatedAuth);
        } else {
            throw new RuntimeException("Author does not exist");
        }
    }

    @Override
    public List<Author> getAllAuthor() {

        return this.authRepo.findAll();
    }

    @Override
    public Author getAuthorById(long id) {
        Optional<Author> Auth = this.authRepo.findById(id);
        if(Auth.isPresent()){
            return Auth.get();
        } else{
            throw new RuntimeException("Book does not exist");
        }
    }

    @Override
    public void deleteAuthor(long id) {
        Optional<Author> Auth = this.authRepo.findById(id);
        if(Auth.isPresent()){
            this.authRepo.deleteById(id);
        } else {
            throw new RuntimeException("Book does not exist");
        }
    }
}
