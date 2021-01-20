package com.krystiankownacki.homebudget.domain.response;

import com.krystiankownacki.homebudget.domain.ResponseStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RechargeResponse {
    private final ResponseStatus status;
    private final String register;
    private final int balance;
}
