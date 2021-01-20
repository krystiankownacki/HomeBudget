package com.krystiankownacki.homebudget.service.builder;

import com.krystiankownacki.homebudget.domain.ResponseStatus;
import com.krystiankownacki.homebudget.domain.response.TransferResponse;
import com.krystiankownacki.homebudget.repository.entity.Register;
import org.springframework.stereotype.Component;

@Component
public class TransferResponseBuilder {

    public TransferResponse buildSuccessfulResponse(Register from, Register to) {
        return TransferResponse.builder()
                .status(ResponseStatus.SUCCESS)
                .fromRegister(from.getRegisterName())
                .fromBalance(from.getBalance())
                .toRegister(to.getRegisterName())
                .toBalance(to.getBalance())
                .build();
    }

    public TransferResponse buildFailureResponse() {
        return TransferResponse.builder()
                .status(ResponseStatus.FAILED)
                .build();
    }
}
