package com.krystiankownacki.homebudget.domain.dto;

import lombok.Value;

@Value
public class RegisterDto {
    String registerName;
    int balance;
}
