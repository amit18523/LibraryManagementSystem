package com.example.demo.Repositry;

import com.example.demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateRepo extends JpaRepository<Category, Long> {
}
