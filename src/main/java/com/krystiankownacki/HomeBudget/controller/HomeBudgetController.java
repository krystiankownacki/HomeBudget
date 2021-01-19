package com.krystiankownacki.homebudget.controller;

import com.krystiankownacki.homebudget.domain.WalletRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HomeBudgetController {

    private final WalletRepository walletRepository;

    @GetMapping("/hello")
    public String hello() {
        log.info("Saving to DB new Wallet");
        Wallet wallet = walletRepository.save(new Wallet());
        return "Saved to DB with ID: " + wallet.getId();
    }

}