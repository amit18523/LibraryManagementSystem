package com.example.demo.Repositry;

import com.example.demo.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Long> {

   // List<Inventory> findByName(String bookName);
}
