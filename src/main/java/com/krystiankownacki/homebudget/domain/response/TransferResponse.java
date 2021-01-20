package com.krystiankownacki.homebudget.domain.response;

import com.krystiankownacki.homebudget.domain.ResponseStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferResponse {
    private final ResponseStatus status;
    private final String fromRegister;
    private final int fromBalance;
    private final String toRegister;
    private final int toBalance;
}
