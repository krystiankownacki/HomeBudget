package com.krystiankownacki.homebudget.service.validator;

import com.krystiankownacki.homebudget.domain.exception.SelfTransferException;
import com.krystiankownacki.homebudget.domain.request.TransferRequest;
import org.springframework.stereotype.Component;

@Component
public class TransferRequestValidator {

    public void validate(TransferRequest transferRequest) {
        if (transferRequest.getFrom().equals(transferRequest.getTo())) {
            throw new SelfTransferException();
        }
    }
}
