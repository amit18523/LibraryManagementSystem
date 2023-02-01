package com.example.demo.Service;

import com.example.demo.Model.TransactionHistory;
import com.example.demo.Model.Wallet;
import com.example.demo.Repositry.TransactionHistoryRepo;
import com.example.demo.Repositry.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class WalletImplement implements WalletInterface {

    @Autowired
    private WalletRepo walletRepo;

    @Autowired
    private TransactionHistoryRepo transactionHistoryRepo;
    @Override
    public Wallet createWallet(Wallet user) {
        if(user.getMoney() % 500 != 0){
            throw new RuntimeException("Money not valid");
        }
        try{
            Long num = user.getUserId();
            Set<TransactionHistory> t = new HashSet<>();
            for(int i = 0; i < user.getTransactionHistory().size(); i++){
                TransactionHistory x = new TransactionHistory();
                x.setMoneyAdded(user.getMoney());
                x.setUserId(user.getUserId());
                t.add(x);
            }
            user.setTransactionHistory(t);
        } catch (RuntimeException e){
                throw new RuntimeException("Id not found");
        }
        return this.walletRepo.save(user);
    }

    @Override
    public Wallet updateWallet(Wallet wallet) {
        Optional<Wallet> walletObj = this.walletRepo.findById(wallet.getWalletId());
        if(walletObj.isPresent()){
            Wallet updatedWallet = walletObj.get();
            updatedWallet.setMoney(updatedWallet.getMoney() + wallet.getMoney());
            return this.walletRepo.save(updatedWallet);
        } else {
            throw new RuntimeException("Wallet does not exist");
        }
    }

    @Override
    public List<Wallet> getAllWallet() {
        return this.walletRepo.findAll();
    }

    @Override
    public Wallet getWalletById(long id) {
        Optional<Wallet> wall = this.walletRepo.findById(id);
        if(wall.isPresent()){
            return wall.get();
        } else{
            throw new RuntimeException("Wallet does not exist");
        }
    }

    @Override
    public void deleteWallet(long id) {
        Optional<Wallet> wall = this.walletRepo.findById(id);
        if(wall.isPresent()){
            walletRepo.deleteById(id);
        } else{
            throw new RuntimeException("Wallet does not exist");
        }
    }
}
