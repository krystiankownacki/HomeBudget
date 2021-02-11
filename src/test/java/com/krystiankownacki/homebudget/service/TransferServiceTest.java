package com.krystiankownacki.homebudget.service;

import com.krystiankownacki.homebudget.domain.exception.InsufficientBalanceException;
import com.krystiankownacki.homebudget.domain.request.TransferRequest;
import com.krystiankownacki.homebudget.domain.response.TransferResponse;
import com.krystiankownacki.homebudget.domain.response.builder.TransferResponseBuilder;
import com.krystiankownacki.homebudget.repository.entity.Register;
import com.krystiankownacki.homebudget.service.validator.TransferRequestValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransferServiceTest {

    private static final String FROM_REGISTER = "foo";
    private static final String TO_REGISTER = "bar";
    private static final int AMOUNT = 100;

    @Mock
    private TransferRequest transferRequest;

    @Mock
    private TransferResponse transferResponse;

    @Mock
    private Register from;

    @Mock
    private Register to;

    @Mock
    private RegisterDatabaseService registerDatabaseService;

    @Mock
    private TransferResponseBuilder transferResponseBuilder;

    @Mock
    private TransferRequestValidator transferRequestValidator;

    @InjectMocks
    private TransferService transferService;

    @Test
    void transferMoneyWithSuccess() {
        when(transferRequest.getFrom()).thenReturn(FROM_REGISTER);
        when(transferRequest.getTo()).thenReturn(TO_REGISTER);
        when(transferRequest.getAmount()).thenReturn(AMOUNT);
        when(registerDatabaseService.findByName(FROM_REGISTER)).thenReturn(from);
        when(registerDatabaseService.findByName(TO_REGISTER)).thenReturn(to);
        when(from.canAfford(AMOUNT)).thenReturn(true);
        when(transferResponseBuilder.buildSuccessfulResponse(from, to)).thenReturn(transferResponse);

        TransferResponse actual = transferService.transfer(transferRequest);

        verify(from).recharge(-AMOUNT);
        verify(to).recharge(AMOUNT);

        assertThat(actual).isEqualTo(transferResponse);
    }

    @Test
    void throwInsufficientBalanceExceptionWhenRegistryHasNotEnoughBalance() {
        when(transferRequest.getFrom()).thenReturn(FROM_REGISTER);
        when(transferRequest.getTo()).thenReturn(TO_REGISTER);
        when(transferRequest.getAmount()).thenReturn(AMOUNT);
        when(registerDatabaseService.findByName(FROM_REGISTER)).thenReturn(from);
        when(registerDatabaseService.findByName(TO_REGISTER)).thenReturn(to);
        when(from.canAfford(AMOUNT)).thenReturn(false);

        assertThrows(InsufficientBalanceException.class, () -> transferService.transfer(transferRequest));
    }
}