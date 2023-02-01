package com.example.demo.Service;

import com.example.demo.Model.Book;
import com.example.demo.Model.Inventory;
import com.example.demo.Repositry.BookRepo;
import com.example.demo.Repositry.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryImplement implements InventoryInterface{
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private InventoryRepo inventoryRepo;

    @Override
    public Inventory addBooks(Inventory books) {
        int cnt = 0;
        String n = books.getBookName();
        List<Book> allBooks = bookRepo.findAll();
        for(Book b : allBooks){
            if(b.getBookName().equals(books.getBookName())){
                cnt++;
            }
        }
        List<Inventory> allInventory = inventoryRepo.findAll();
        Long totalCount = Long.valueOf(cnt);
        for(Inventory i : allInventory){
            if(i.getBookName().equals(books.getBookName())){
                totalCount = Math.max(cnt, i.getTotalCount());
            }
        }

        books.setTotalCount(totalCount);
        System.out.print(cnt);
        books.setCount(cnt);
        return this.inventoryRepo.save(books);
    }

//    @Override
//    public Inventory removeBook(Inventory books) {
//        for(StoreBook i : books.getBookIds()){
//            Optional<Book> b = bookRepo.findById(i.getId());
//            if(!b.isPresent()){
//                throw new RuntimeException("Book is not present");
//            }
//
//        }
//    }
}
