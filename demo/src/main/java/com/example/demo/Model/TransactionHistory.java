package com.example.demo.Model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transactionId", nullable = false)
    private Long transactionId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @CreationTimestamp
    private Date time;

    @Column(name = "moneyAdded")
    private Long moneyAdded;

    @Column(name = "userId")
    private Long userId;
    @Column(name = "moneyDeducted")
    private Long moneyDeducted;



    public Long getTransactionId() {
        return transactionId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getMoneyAdded() {
        return moneyAdded;
    }

    public void setMoneyAdded(Long moneyAdded) {
        this.moneyAdded = moneyAdded;
    }

    public Long getMoneyDeducted() {
        return moneyDeducted;
    }

    public void setMoneyDeducted(Long moneyDeducted) {
        this.moneyDeducted = moneyDeducted;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }




}
