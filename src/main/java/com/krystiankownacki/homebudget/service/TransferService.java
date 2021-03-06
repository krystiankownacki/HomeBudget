package com.krystiankownacki.homebudget.service;

import com.krystiankownacki.homebudget.domain.exception.RegisterNotFoundException;
import com.krystiankownacki.homebudget.domain.request.TransferRequest;
import com.krystiankownacki.homebudget.domain.response.TransferResponse;
import com.krystiankownacki.homebudget.repository.entity.Register;
import com.krystiankownacki.homebudget.service.builder.TransferResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransferService {

    private final RegisterDatabaseService registerDatabaseService;
    private final TransferResponseBuilder transferResponseBuilder;

    @Transactional
    public TransferResponse transfer(TransferRequest transferRequest) {
        try {
            Register from = registerDatabaseService.findByName(transferRequest.getFrom());
            Register to = registerDatabaseService.findByName(transferRequest.getTo());
            int amountToTransfer = transferRequest.getAmount();
            log.debug("Transferring {} amount from Register: {} to Register: {}", amountToTransfer, transferRequest.getFrom(), transferRequest.getTo());

            if (from.canAfford(amountToTransfer)) {
                from.recharge(-amountToTransfer);
                to.recharge(amountToTransfer);
                return transferResponseBuilder.buildSuccessfulResponse(from, to);
            } else {
                return transferResponseBuilder.buildFailureResponse();
            }
        } catch (RegisterNotFoundException e) {
            return transferResponseBuilder.buildFailureResponse();
        }
    }
}
