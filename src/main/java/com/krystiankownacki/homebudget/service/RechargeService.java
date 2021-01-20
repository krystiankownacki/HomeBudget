package com.krystiankownacki.homebudget.service;

import com.krystiankownacki.homebudget.domain.exception.RegisterNotFoundException;
import com.krystiankownacki.homebudget.domain.request.RechargeRequest;
import com.krystiankownacki.homebudget.domain.response.RechargeResponse;
import com.krystiankownacki.homebudget.repository.entity.Register;
import com.krystiankownacki.homebudget.service.builder.RechargeResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class RechargeService {

    private final RegisterDatabaseService registerDatabaseService;
    private final RechargeResponseBuilder rechargeResponseBuilder;

    @Transactional
    public RechargeResponse recharge(RechargeRequest rechargeRequest) {
        try {
            log.debug("Recharging amount: {} to Register: {}", rechargeRequest.getAmount(), rechargeRequest.getRegisterName());
            Register register = registerDatabaseService.findByName(rechargeRequest.getRegisterName());
            register.recharge(rechargeRequest.getAmount());

            return rechargeResponseBuilder.buildSuccessfulResponse(register);
        } catch (RegisterNotFoundException e) {
            return rechargeResponseBuilder.buildFailureResponse();
        }
    }
}
