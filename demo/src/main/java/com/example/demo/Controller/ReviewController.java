package com.example.demo.Controller;

import com.example.demo.Model.Review;
import com.example.demo.Service.ReviewImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewImplement reviewImplement;

    @GetMapping("/getLikes")
    private ResponseEntity<List<Review>>  giveLikes(){
        return ResponseEntity.ok().body(this.reviewImplement.sortBylikes());
    }
    @PostMapping("/addReview")
    private ResponseEntity<Review> addReview(@RequestBody Review review){
        return ResponseEntity.ok().body(this.reviewImplement.addReview(review));
    }
}
