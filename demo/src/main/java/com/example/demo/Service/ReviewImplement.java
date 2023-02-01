package com.example.demo.Service;


import com.example.demo.Model.Comments;
import com.example.demo.Model.Review;
import com.example.demo.Repositry.BookRepo;
import com.example.demo.Repositry.CommentRepo;
import com.example.demo.Repositry.InventoryRepo;
import com.example.demo.Repositry.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ReviewImplement implements ReviewInterface {
    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private CommentRepo commentRepo;
    @Override
    public List<Review> sortBylikes() {
        return this.reviewRepo.OrderByTotalLikesDesc();
    }

    @Override
    public Review addReview(Review review) {
        Boolean x = review.isUserLike();
        String name = review.getBookName();
        for(Comments it : review.getComments()){
            Comments rr = new Comments();
            rr.setUserWritten(it.getUserWritten());
            rr.setBookName(review.getBookName());
            it.setBookName(review.getBookName());
            this.commentRepo.save(rr);
        }
        Optional<Review> otherR = Optional.ofNullable(reviewRepo.findByBookName(review.getBookName()));
        if (otherR.isPresent()) {
            Review r = otherR.get();
            if (x.equals(true)) {
                Long cnt = 1l + r.getTotalLikes();
                this.reviewRepo.deleteById(r.getReviewId());
                review.setTotalLikes(cnt);
                return this.reviewRepo.save(review);
            } else if (x.equals(false)) {
                Long cnt = -1l + r.getTotalLikes();
                this.reviewRepo.deleteById(r.getReviewId());
                review.setTotalLikes(cnt);
                return this.reviewRepo.save(review);
            }
        }

        if (x.equals(true)) {
            review.setTotalLikes(1);
        } else if (x.equals(false)) {

            review.setTotalLikes(-1);
        }
        return this.reviewRepo.save(review);
    }
}
