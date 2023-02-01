package com.example.demo.Controller;

import com.example.demo.Model.Wallet;
import com.example.demo.Service.WalletImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class walletController {
    @Autowired
    private WalletImplement walletImplement;

    @GetMapping("/wallet")
    private ResponseEntity<List<Wallet>> getAllWallet(){
        return ResponseEntity.ok().body(this.walletImplement.getAllWallet());
    }

    @GetMapping("/wallet/{walletId}")
    private Wallet getWallet(@PathVariable Long walletId){
        return this.walletImplement.getWalletById(walletId);
    }

    @PostMapping("/createWallet")
    private ResponseEntity<Wallet> saveUser(@RequestBody Wallet wallet){
        return ResponseEntity.ok().body(this.walletImplement.createWallet(wallet));
    }

    @PutMapping("/wallet/{walletID}")
    private ResponseEntity<Wallet> UpdateWallet(@PathVariable long walletId, @RequestBody Wallet wallet){
        wallet.setWalletId(walletId);
        return ResponseEntity.ok().body(this.walletImplement.updateWallet(wallet));
    }

    @DeleteMapping("/wallet/{id}")
    public void deleteWallet(@PathVariable long id) {
        walletImplement.deleteWallet(id);
    }
}
