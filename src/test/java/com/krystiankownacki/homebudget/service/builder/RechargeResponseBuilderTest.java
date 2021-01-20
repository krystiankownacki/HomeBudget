package com.krystiankownacki.homebudget.service.builder;

import com.krystiankownacki.homebudget.domain.ResponseStatus;
import com.krystiankownacki.homebudget.domain.response.RechargeResponse;
import com.krystiankownacki.homebudget.repository.entity.Register;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RechargeResponseBuilderTest {

    private static final String NAME = "test";
    private static final int BALANCE = 0;

    @Mock
    private Register register;

    @InjectMocks
    private RechargeResponseBuilder rechargeResponseBuilder;

    @Test
    void buildSuccessfulResponse() {
        when(register.getRegisterName()).thenReturn(NAME);
        when(register.getBalance()).thenReturn(BALANCE);

        RechargeResponse actual = rechargeResponseBuilder.buildSuccessfulResponse(register);

        assertThat(actual.getStatus()).isEqualTo(ResponseStatus.SUCCESS);
        assertThat(actual.getRegister()).isEqualTo(NAME);
        assertThat(actual.getBalance()).isEqualTo(BALANCE);
    }

    @Test
    void buildFailureResponse() {
        RechargeResponse actual = rechargeResponseBuilder.buildFailureResponse();

        assertThat(actual.getStatus()).isEqualTo(ResponseStatus.FAILED);
    }
}