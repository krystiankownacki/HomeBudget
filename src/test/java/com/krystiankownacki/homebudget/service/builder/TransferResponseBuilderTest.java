package com.krystiankownacki.homebudget.service.builder;

import com.krystiankownacki.homebudget.domain.ResponseStatus;
import com.krystiankownacki.homebudget.domain.response.TransferResponse;
import com.krystiankownacki.homebudget.domain.response.builder.TransferResponseBuilder;
import com.krystiankownacki.homebudget.repository.entity.Register;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransferResponseBuilderTest {

    private static final String FROM_REGISTER_NAME = "test";
    private static final String TO_REGISTER_NAME = "foo";
    private static final int BALANCE = 1000;

    @Mock
    private Register from;

    @Mock
    private Register to;

    @InjectMocks
    private TransferResponseBuilder transferResponseBuilder;

    @Test
    void buildSuccessfulResponse() {
        when(from.getRegisterName()).thenReturn(FROM_REGISTER_NAME);
        when(from.getBalance()).thenReturn(BALANCE);
        when(to.getRegisterName()).thenReturn(TO_REGISTER_NAME);
        when(to.getBalance()).thenReturn(BALANCE);

        TransferResponse actual = transferResponseBuilder.buildSuccessfulResponse(from, to);

        assertThat(actual.getStatus()).isEqualTo(ResponseStatus.SUCCESS);
        assertThat(actual.getFromRegister()).isEqualTo(FROM_REGISTER_NAME);
        assertThat(actual.getFromBalance()).isEqualTo(BALANCE);
        assertThat(actual.getToRegister()).isEqualTo(TO_REGISTER_NAME);
        assertThat(actual.getToBalance()).isEqualTo(BALANCE);
    }

    @Test
    void buildFailureResponse() {
        TransferResponse actual = transferResponseBuilder.buildFailureResponse();

        assertThat(actual.getStatus()).isEqualTo(ResponseStatus.FAILED);
    }
}