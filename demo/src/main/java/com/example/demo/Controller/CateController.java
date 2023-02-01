package com.example.demo.Controller;

import com.example.demo.Model.Category;
import com.example.demo.Service.CateInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CateController {
    @Autowired
    private CateInterface catecon;

    @GetMapping("/category")
    private ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.ok().body(this.catecon.getAllCategory());
    }

    @GetMapping("/category/{categoryId}")
    private Category getCategory(@PathVariable Long categoryID){
        return this.catecon.getCategoryById(categoryID);
    }

    @PostMapping("/createCategory")
    private ResponseEntity<Category> saveCat(@RequestBody Category cate){
        return ResponseEntity.ok().body(this.catecon.createCategory(cate));
    }

    @PutMapping("/category/{categoryId}")
    private ResponseEntity<Category> UpdateCate(@PathVariable long userId, @RequestBody Category cat){
        cat.setCategoryId(userId);
        return ResponseEntity.ok().body(this.catecon.updateCategory(cat));
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable long id) {
        catecon.deleteCategory(id);
    }
}
