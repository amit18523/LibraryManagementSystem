package com.example.demo.Repositry;

import com.example.demo.Model.IssueDesk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueDeskRepo extends JpaRepository<IssueDesk, Long> {
}
