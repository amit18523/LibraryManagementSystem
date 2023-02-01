package com.example.demo.Controller;

import com.example.demo.Model.Userr;
import com.example.demo.Service.UserrImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserrImplement userCon;

    @GetMapping("/user")
    private ResponseEntity<List<Userr>> getAllUser(){
        return ResponseEntity.ok().body(this.userCon.getAllUserr());
    }

    @GetMapping("/users/{userId}")
    private Userr getUser(@PathVariable Long userId){
        return this.userCon.getUserrById(userId);
    }

    @PostMapping("/createUser")
    private ResponseEntity<Userr> saveUser(@RequestBody Userr userr){
        return ResponseEntity.ok().body(this.userCon.createUserr(userr));
    }

    @PutMapping("/users/{userId}")
    private ResponseEntity<Userr> UpdateUsser(@PathVariable long userId, @RequestBody Userr usr){
        usr.setUserId(userId);
        return ResponseEntity.ok().body(this.userCon.updateUserr(usr));
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id) {
        userCon.deleteUserr(id);
    }
}
