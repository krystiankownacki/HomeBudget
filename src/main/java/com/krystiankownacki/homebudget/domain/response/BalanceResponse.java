package com.krystiankownacki.homebudget.domain.response;

import com.krystiankownacki.homebudget.domain.dto.RegisterDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BalanceResponse {
    private List<RegisterDto> registers;
}
