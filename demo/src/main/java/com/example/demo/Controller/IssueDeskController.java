package com.example.demo.Controller;

import com.example.demo.Model.IssueDesk;
import com.example.demo.Service.IssueDeskImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssueDeskController {
    @Autowired
    private IssueDeskImplement issueDeskImplement;

    @GetMapping("/Hi")
    private String fun(){
        return  "hello world";
    }

    @GetMapping("/Issue")
    private ResponseEntity<List<IssueDesk>> getAllIssueDesk(){
        return ResponseEntity.ok().body(this.issueDeskImplement.allIssue());
    }

    @PostMapping("/createIssue")
    private ResponseEntity<IssueDesk> saveBook(@RequestBody IssueDesk issue){
        return ResponseEntity.ok().body(this.issueDeskImplement.issueBook(issue));
    }

    @PutMapping("/Issue/{IssueID}")
    private ResponseEntity<IssueDesk> updateBook(@PathVariable long issueID, @RequestBody IssueDesk issueDesk){
        // book.setBookId(bookId);
        return ResponseEntity.ok().body(this.issueDeskImplement.returnBook(issueDesk));
    }
}
