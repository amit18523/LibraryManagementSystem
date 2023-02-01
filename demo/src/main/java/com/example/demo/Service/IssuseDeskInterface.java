package com.example.demo.Service;

import com.example.demo.Model.IssueDesk;

import java.util.List;

public interface IssuseDeskInterface {
    IssueDesk issueBook(IssueDesk obj);
    IssueDesk returnBook(IssueDesk obj);
    List<IssueDesk> allIssue();


}
