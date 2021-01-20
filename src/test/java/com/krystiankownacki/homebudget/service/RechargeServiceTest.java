package com.krystiankownacki.homebudget.service;

import com.krystiankownacki.homebudget.domain.exception.RegisterNotFoundException;
import com.krystiankownacki.homebudget.domain.request.RechargeRequest;
import com.krystiankownacki.homebudget.domain.response.RechargeResponse;
import com.krystiankownacki.homebudget.repository.entity.Register;
import com.krystiankownacki.homebudget.service.builder.RechargeResponseBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class RechargeServiceTest {

    private static final String NAME = "register";
    private static final int AMOUNT_TO_RECHARGE = 1;

    @Mock
    private Register register;

    @Mock
    private RechargeRequest rechargeRequest;

    @Mock
    private RechargeResponse rechargeResponse;

    @Mock
    private RegisterDatabaseService registerDatabaseService;

    @Mock
    private RechargeResponseBuilder rechargeResponseBuilder;
    ;

    @InjectMocks
    private RechargeService rechargeService;

    @Test
    void rechargeSuccessful() {
        when(rechargeRequest.getRegisterName()).thenReturn(NAME);
        when(rechargeRequest.getAmount()).thenReturn(AMOUNT_TO_RECHARGE);
        when(registerDatabaseService.findByName(NAME)).thenReturn(register);
        when(rechargeResponseBuilder.buildSuccessfulResponse(register)).thenReturn(rechargeResponse);

        RechargeResponse actual = rechargeService.recharge(rechargeRequest);

        verify(register).recharge(AMOUNT_TO_RECHARGE);

        assertThat(actual).isEqualTo(rechargeResponse);
    }

    @Test
    void rechargeFailed() {
        when(rechargeRequest.getRegisterName()).thenReturn(NAME);
        when(registerDatabaseService.findByName(NAME)).thenThrow(new RegisterNotFoundException(NAME));
        when(rechargeResponseBuilder.buildFailureResponse()).thenReturn(rechargeResponse);

        RechargeResponse actual = rechargeService.recharge(rechargeRequest);

        verifyNoInteractions(register);

        assertThat(actual).isEqualTo(rechargeResponse);
    }
}