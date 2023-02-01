package com.example.demo.Repositry;

import com.example.demo.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    List<Review> OrderByTotalLikesDesc();
    Review findByBookName(String name);

    //void deletebyBookName(String name);
}
