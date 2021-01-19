package com.krystiankownacki.homebudget.controller;

import com.krystiankownacki.homebudget.domain.Wallet;
import com.krystiankownacki.homebudget.domain.WalletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HomeBudgetController {

    private final WalletRepository walletRepository;

    @GetMapping("/hello")
    public String hello() {
        log.info("Saving to DB new Wallet");
        var walletToSave = new Wallet();
        Wallet wallet = walletRepository.save(walletToSave);
        return "Saved to DB with ID: " + wallet.getId();
    }

}