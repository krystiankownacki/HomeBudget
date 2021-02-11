package com.krystiankownacki.homebudget.service.validator;

import com.krystiankownacki.homebudget.domain.exception.SelfTransferException;
import com.krystiankownacki.homebudget.domain.request.TransferRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransferRequestValidatorTest {

    private static final String REGISTER = "test";

    @Mock
    private TransferRequest transferRequest;

    @InjectMocks
    private TransferRequestValidator transferRequestValidator;

    @Test
    void shouldThrowSelfTransferExceptionWhenRequestHasTheSameRegisters() {
        when(transferRequest.getFrom()).thenReturn(REGISTER);
        when(transferRequest.getTo()).thenReturn(REGISTER);

        assertThrows(SelfTransferException.class, () -> transferRequestValidator.validate(transferRequest));

    }
}