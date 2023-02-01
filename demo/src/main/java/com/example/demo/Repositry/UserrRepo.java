package com.example.demo.Repositry;

import com.example.demo.Model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserrRepo extends JpaRepository<Userr, Long> {
}
