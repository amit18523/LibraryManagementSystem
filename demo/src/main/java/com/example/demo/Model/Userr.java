package com.example.demo.Model;

import javax.persistence.*;

/* Name doesn't conflict */

@Entity
@Table(name = "Userr")
public class Userr {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "email", nullable = false, unique = true, length = 25)
    private String email;

    @Column(name = "phonNo" , nullable = false, length = 25)
    private String phoneNO;

    @Column(name = "userName",nullable = false, unique = true)
    private String userName;
    @Column(name = "firstName",nullable = false, length = 25)
    private String firstName;

    @Column(name = "lastName" , length = 25)
    private String lastName;


    @Column(name = "LastBookId")
    private Long lastBookId;
    @Column(name = "bookCount")
    private Integer bookCount;
    @OneToOne(cascade = { CascadeType.ALL})
    @JoinColumn(name = "walletID")
    private Wallet wallet;
    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    @Column(name = "status" , nullable = false, length = 25)
    private boolean status;

    public Long getLastBookId() {
        return lastBookId;
    }

    public void setLastBookId(Long lastBookId) {
        this.lastBookId = lastBookId;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public boolean isStatus() {

        return status;
    }

    public void setStatus(boolean status) {

        this.status = status;
    }

    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPhoneNO() {

        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {

        this.phoneNO = phoneNO;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Userr{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", phoneNO='" + phoneNO + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
