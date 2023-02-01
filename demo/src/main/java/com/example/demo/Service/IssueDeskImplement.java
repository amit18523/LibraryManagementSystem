package com.example.demo.Service;

import com.example.demo.Model.*;
import com.example.demo.Repositry.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IssueDeskImplement implements IssuseDeskInterface {
    @Autowired
    private UserrRepo userrRepo;

    @Autowired
    private WalletRepo walletRepo;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private IssueDeskRepo issueDeskRepo;

    @Autowired
    private TransactionHistoryRepo transactionHistoryRepo;

    @Autowired
    private InventoryRepo inventoryRepo;

    @Override
    public IssueDesk issueBook(IssueDesk obj) {
        Optional<Book> bookObj = bookRepo.findById(obj.getCurrBookId());
        Optional<Userr> userrObj = userrRepo.findById(obj.getCurrUserId());
        Optional<Wallet> walletObj = walletRepo.findById(obj.getCurrWalletId());
        try {
            // code to create count and to perform number of count
            Inventory ix = new Inventory();
            List<Inventory> inventoryObj = inventoryRepo.findAll();
            for(Inventory i : inventoryObj) {
                Book b  = bookObj.get();
                if(i.getBookName().equals(b.getBookName())){
                    if(i.getCount() == 0){
                        throw new RuntimeException("Count is zero");
                    }
                    ix.setInventoryId(i.getInventoryId());
                    ix.setTotalCount(i.getTotalCount());
                    ix.setCount(i.getCount() - 1);
                    ix.setBookName(i.getBookName());
                    inventoryRepo.deleteById(i.getInventoryId());
                    inventoryRepo.save(ix);
                }
            }
        } catch (Exception e){
            throw new RuntimeException("Inventory is empty");
        }

        if(bookObj.isPresent() && userrObj.isPresent() && walletObj.isPresent()){
            Book b = bookObj.get();
            Userr u = userrObj.get();
            Wallet w = walletObj.get();
            if(!u.getUserId().equals( w.getUserId())){
                throw new RuntimeException("Wallet belong to other user " + u.getUserId() + " " + w.getUserId());
            }
            if(w.getMoney() <  b.getPrice()){
                throw new RuntimeException("Wallet does not have sufficient balance");
            } else {
                if(u.getBookCount() >= 3){
                    throw new RuntimeException("Please return books");
                } else if(u.getLastBookId() ==  b.getBookId()){
                    throw new RuntimeException("Cannot Issue last book");
                }else {
                    if(u.isStatus() == false){
                        throw new RuntimeException("user status false");
                    }
                    TransactionHistory t = new TransactionHistory();
                    t.setUserId(obj.getCurrUserId());
                    t.setMoneyDeducted((long) (.2 * b.getPrice()));
                    transactionHistoryRepo.save(t);
                    w.deductMoney((long) (w.getMoney() - .2 * b.getPrice()));
                    u.setLastBookId(b.getBookId());
                    u.setBookCount(u.getBookCount() + 1);
                    return this.issueDeskRepo.save(obj);
                }
            }

        } else {
            System.out.print("\n" + obj.getCurrBookId() + " " + obj.getCurrWalletId() + " " + obj.getCurrUserId() + "\n" +"\n");
            throw  new RuntimeException("No such entity exist here " + obj.getCurrUserId() + "" + obj.getCurrWalletId() + "" +obj.getCurrBookId());
        }
    }

    @Override
    public IssueDesk returnBook(IssueDesk obj) {
        Optional<Book> bookObj = bookRepo.findById(obj.getCurrBookId());
        Optional<Userr> userrObj = userrRepo.findById(obj.getCurrUserId());
        Optional<Wallet> walletObj = walletRepo.findById(obj.getCurrWalletId());
        if(bookObj.isPresent() && userrObj.isPresent() && walletObj.isPresent()){
            Book b = bookObj.get();
            Userr u = userrObj.get();
            Wallet w = walletObj.get();

            TransactionHistory t = new TransactionHistory();
            t.setUserId(obj.getCurrUserId());
            t.setMoneyAdded((long) (.1 * b.getPrice()));
            transactionHistoryRepo.save(t);
            w.addMoney((long) (w.getMoney() +  .1 * b.getPrice()));
            u.setLastBookId(b.getBookId());
            u.setBookCount(u.getBookCount() - 1);
            return this.issueBook(obj);
        } else {
            throw new RuntimeException("Invalid Book return");
        }
    }
    @Override
    public List<IssueDesk> allIssue() {
        return this.issueDeskRepo.findAll();
    }
}