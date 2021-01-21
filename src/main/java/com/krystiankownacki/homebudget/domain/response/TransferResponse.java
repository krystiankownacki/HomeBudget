package com.krystiankownacki.homebudget.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.krystiankownacki.homebudget.domain.ResponseStatus;
import lombok.Builder;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
public class TransferResponse {

    private final ResponseStatus status;

    @JsonInclude(NON_NULL)
    private final String fromRegister;

    @JsonInclude(NON_DEFAULT)
    private final int fromBalance;

    @JsonInclude(NON_NULL)
    private final String toRegister;

    @JsonInclude(NON_DEFAULT)
    private final int toBalance;
}
