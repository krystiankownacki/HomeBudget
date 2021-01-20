package com.krystiankownacki.homebudget.controller;

import com.krystiankownacki.homebudget.domain.request.RechargeRequest;
import com.krystiankownacki.homebudget.domain.request.TransferRequest;
import com.krystiankownacki.homebudget.domain.response.BalanceResponse;
import com.krystiankownacki.homebudget.domain.response.RechargeResponse;
import com.krystiankownacki.homebudget.domain.response.TransferResponse;
import com.krystiankownacki.homebudget.service.BalanceService;
import com.krystiankownacki.homebudget.service.RechargeService;
import com.krystiankownacki.homebudget.service.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HomeBudgetControllerTest {

    @Mock
    private RechargeResponse rechargeResponse;

    @Mock
    private RechargeRequest rechargeRequest;

    @Mock
    private BalanceResponse balanceResponse;

    @Mock
    private TransferRequest transferRequest;

    @Mock
    private TransferResponse transferResponse;

    @Mock
    private RechargeService rechargeService;

    @Mock
    private BalanceService balanceService;

    @Mock
    private TransferService transferService;

    @InjectMocks
    private HomeBudgetController homeBudgetController;

    @Test
    void rechargeRegister() {
        when(rechargeService.recharge(rechargeRequest)).thenReturn(rechargeResponse);

        RechargeResponse actual = homeBudgetController.rechargeRegister(rechargeRequest);

        assertThat(actual).isEqualTo(rechargeResponse);
    }

    @Test
    void getCurrentBalance() {
        when(balanceService.getBalanceForAllRegisters()).thenReturn(balanceResponse);

        BalanceResponse actual = homeBudgetController.getCurrentBalance();

        assertThat(actual).isEqualTo(balanceResponse);
    }

    @Test
    void transferAmount() {
        when(transferService.transfer(transferRequest)).thenReturn(transferResponse);

        TransferResponse actual = homeBudgetController.transferAmount(transferRequest);

        assertThat(actual).isEqualTo(transferResponse);
    }
}