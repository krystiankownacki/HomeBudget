package com.krystiankownacki.homebudget.controller;

import com.krystiankownacki.homebudget.domain.request.RechargeRequest;
import com.krystiankownacki.homebudget.domain.request.TransferRequest;
import com.krystiankownacki.homebudget.domain.response.BalanceResponse;
import com.krystiankownacki.homebudget.domain.response.RechargeResponse;
import com.krystiankownacki.homebudget.domain.response.TransferResponse;
import com.krystiankownacki.homebudget.service.BalanceService;
import com.krystiankownacki.homebudget.service.RechargeService;
import com.krystiankownacki.homebudget.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Valid
@RestController
@RequiredArgsConstructor
public class HomeBudgetController {

    private final RechargeService rechargeService;
    private final BalanceService balanceService;
    private final TransferService transferService;

    @PostMapping("/recharge")
    public RechargeResponse rechargeRegister(@RequestBody @Valid RechargeRequest rechargeRequest) {
        return rechargeService.recharge(rechargeRequest);
    }

    @GetMapping("/balance")
    public BalanceResponse getCurrentBalance() {
        return balanceService.getBalanceForAllRegisters();
    }

    @PostMapping("/transfer")
    public TransferResponse transferAmount(@RequestBody @Valid TransferRequest transferRequest) {
        return transferService.transfer(transferRequest);
    }
}