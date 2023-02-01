package com.example.demo.Model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issueDesk")
public class IssueDesk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "issueId")
    private Long issueId;



    @CreationTimestamp
    private Date issueTime;

    @UpdateTimestamp
    private Date returnTime;

    @Column(name = "currUserId")
    Long currUserId;

    @Column(name = "currBookId")
    Long currBookId;

    @Column(name = "currWalletId")
    Long currWalletId;

    public Long getCurrUserId() {
        return currUserId;
    }

    public void setCurrUserId(Long currUserId) {
        this.currUserId = currUserId;
    }

    public Long getCurrBookId() {
        return currBookId;
    }

    public void setCurrBookId(Long currBookId) {
        this.currBookId = currBookId;
    }

    public Long getCurrWalletId() {
        return currWalletId;
    }

    public void setCurrWalletId(Long currWalletId) {
        this.currWalletId = currWalletId;
    }





    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

}


