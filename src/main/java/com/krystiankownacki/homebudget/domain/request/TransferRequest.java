package com.krystiankownacki.homebudget.domain.request;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class TransferRequest {

    @NotNull
    private String from;

    @NotNull
    private String to;

    @NotNull
    @Min(1)
    private int amount;
}
