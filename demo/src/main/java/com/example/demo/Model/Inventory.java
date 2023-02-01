package com.example.demo.Model;

import javax.persistence.*;


@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventoryId", nullable = false)
    private Long inventoryId;

    @Column(name = "count")
    int count;

    @Column(name = "bookName")
    private String bookName;

    @Column(name = "totalCount")
    private Long totalCount;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }


}
