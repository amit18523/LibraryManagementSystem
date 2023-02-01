package com.example.demo.Service;

import com.example.demo.Model.Review;

import java.util.List;

public interface ReviewInterface {
    List<Review> sortBylikes();
    Review addReview(Review review);
//    void update (Review review);
}
