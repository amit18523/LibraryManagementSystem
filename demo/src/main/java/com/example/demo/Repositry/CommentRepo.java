package com.example.demo.Repositry;

import com.example.demo.Model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comments, Long> {
}
