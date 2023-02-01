package com.example.demo.Service;

import com.example.demo.Model.TransactionHistory;
import com.example.demo.Model.Userr;
import com.example.demo.Repositry.TransactionHistoryRepo;
import com.example.demo.Repositry.UserrRepo;
import com.example.demo.Repositry.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserrImplement implements UserrInterface{

    @Autowired
    private UserrRepo userrRepo;

    @Autowired
    private WalletRepo walletRepo;

    @Autowired
    private TransactionHistoryRepo transactionHistoryRepo;

    @Override
    public Userr createUserr(Userr userr) {
        Random r = new Random();
        Long val = Long.valueOf(Integer.hashCode(r.nextInt()));
        val = Math.abs(val);
        val = val % 10000;
        userr.setUserId(val);
        Set<TransactionHistory> t = new HashSet<>();
        val = Math.abs(val);
        val = val % 10000;
        userr.getWallet().setUserId(val);
        for(int i = 0; i < userr.getWallet().getTransactionHistory().size(); i++) {
            TransactionHistory x = new TransactionHistory();
            x.setMoneyAdded(userr.getWallet().getMoney());
            x.setUserId(val);
            t.add(x);
        }
        Long amount = userr.getWallet().getMoney();
        userr.getWallet().setTransactionHistory(t);;
        userr.getWallet().setUserId(val);
        return this.userrRepo.save(userr);
    }

    @Override
    public Userr updateUserr(Userr userr) {
        Optional<Userr> userObj = this.userrRepo.findById(userr.getUserId());
        if(userObj.isPresent()){
            Userr updatedUser = userObj.get();
            updatedUser.setEmail(userr.getEmail());
            updatedUser.setPhoneNO(userr.getPhoneNO());
            updatedUser.setStatus(userr.isStatus());
            updatedUser.setUserName(userr.getUserName());
            return this.userrRepo.save(updatedUser);
        } else {
            throw new RuntimeException("user does not exist");
        }
    }

    @Override
    public List<Userr> getAllUserr() {
        return this.userrRepo.findAll();
    }



    @Override
    public Userr getUserrById(long userId) {
        Optional<Userr> user = this.userrRepo.findById(userId);
        if(user.isPresent()){
            return user.get();
        } else{
            throw new RuntimeException("User does not exist");
        }
    }

    public void deleteUserr(long id) {
        Optional<Userr> user = this.userrRepo.findById(id);
        if(user.isPresent()){
            this.userrRepo.deleteById(id);
        } else {
            throw new RuntimeException("User does not exist");
        }
    }
}
