package com.krystiankownacki.homebudget.domain.response.builder;

import com.krystiankownacki.homebudget.domain.ResponseStatus;
import com.krystiankownacki.homebudget.domain.response.RechargeResponse;
import com.krystiankownacki.homebudget.repository.entity.Register;
import org.springframework.stereotype.Component;

@Component
public class RechargeResponseBuilder {

    public RechargeResponse buildSuccessfulResponse(Register register) {
        return RechargeResponse.builder()
                .status(ResponseStatus.SUCCESS)
                .register(register.getRegisterName())
                .balance(register.getBalance())
                .build();
    }
}
