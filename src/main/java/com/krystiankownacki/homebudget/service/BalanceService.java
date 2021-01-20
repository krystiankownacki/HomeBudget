package com.krystiankownacki.homebudget.service;

import com.krystiankownacki.homebudget.domain.dto.RegisterDto;
import com.krystiankownacki.homebudget.domain.response.BalanceResponse;
import com.krystiankownacki.homebudget.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class BalanceService {

    private final RegisterRepository registerRepository;

    public BalanceResponse getBalanceForAllRegisters() {
        log.debug("Fetching balances for all registers");
        List<RegisterDto> registers = registerRepository.findAllByRegisterNameNotNull();

        return BalanceResponse.builder()
                .registers(registers)
                .build();
    }
}
