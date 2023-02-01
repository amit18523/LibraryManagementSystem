package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "Comment")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "comment_id", nullable = false)
    private Long commentId;

    @Column(name = "userWritten")
    String userWritten;

    @Column(name = "bookName")
    String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public Long getCommentId() {
        return commentId;
    }

    public String getUserWritten() {
        return userWritten;
    }

    public void setUserWritten(String userWritten) {
        this.userWritten = userWritten;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

}
