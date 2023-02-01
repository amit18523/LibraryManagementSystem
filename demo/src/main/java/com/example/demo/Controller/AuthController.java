package com.example.demo.Controller;

import com.example.demo.Model.Author;
import com.example.demo.Service.AuthImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {
    @Autowired
    private AuthImplement Authcon;

    @GetMapping("/Author")
    private ResponseEntity<List<Author>> getAllAuthor(){
        return ResponseEntity.ok().body(this.Authcon.getAllAuthor());
    }

    @GetMapping("/Author/{AuthorId}")
    private Author getAuthor(@PathVariable Long AuthorId){
        return this.Authcon.getAuthorById(AuthorId);
    }

    @PostMapping("/createAuth")
    private ResponseEntity<Author> saveAuthor(@RequestBody Author Auth){
        return ResponseEntity.ok().body(this.Authcon.createAuthor(Auth));
    }

    @PutMapping("/Author/{AuthId}")
    private ResponseEntity<Author> UpdateAuth(@PathVariable long userId, @RequestBody Author Auth){
        Auth.setAuthorId(userId);
        return ResponseEntity.ok().body(this.Authcon.updateAuthor(Auth));
    }

    @DeleteMapping("/Author/{id}")
    public void deleteUser(@PathVariable long id) {
        Authcon.deleteAuthor(id);
    }
}
