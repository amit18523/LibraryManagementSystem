package com.example.demo.Controller;
import com.example.demo.Model.Inventory;
import com.example.demo.Service.InventoryImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
    @Autowired
    private InventoryImplement inventoryImplement;

    @PostMapping("crateInventory")
    private ResponseEntity<Inventory> saveUser(@RequestBody Inventory books){
        return ResponseEntity.ok().body(this.inventoryImplement.addBooks(books));
    }
}
