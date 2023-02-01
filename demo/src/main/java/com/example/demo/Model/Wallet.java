package com.example.demo.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "walletId", nullable = false)
    private Long walletId;

    @Column(name = "userId", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "Money")
    private Long Money;

    @Column(name = "userId")
    private Long userId;
     @OneToMany(cascade = { CascadeType.ALL})
     private Set<TransactionHistory> transactionHistory = new HashSet<>();


    public Long getWalletId() {
        return walletId;
    }

    public Set<TransactionHistory> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(Set<TransactionHistory> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }



    public Long getMoney() {
        return Money;
    }

    public void setMoney(Long money) {

            Money = money;

    }
    public void deductMoney(Long money){
        this.Money = money;
    }
    public void addMoney(Long money){
        this.Money = money;
    }
}
