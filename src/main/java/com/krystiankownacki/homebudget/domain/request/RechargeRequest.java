package com.krystiankownacki.homebudget.domain.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class RechargeRequest {

    @NotNull
    private String registerName;

    @NotNull
    @Min(1)
    private int amount;
}
