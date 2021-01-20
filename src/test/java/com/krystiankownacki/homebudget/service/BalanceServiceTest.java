package com.krystiankownacki.homebudget.service;

import com.krystiankownacki.homebudget.domain.dto.RegisterDto;
import com.krystiankownacki.homebudget.domain.response.BalanceResponse;
import com.krystiankownacki.homebudget.repository.RegisterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BalanceServiceTest {

    @Mock
    private List<RegisterDto> registers;

    @Mock
    private RegisterRepository registerRepository;

    @InjectMocks
    private BalanceService balanceService;

    @Test
    void getBalanceForAllRegisters() {
        when(registerRepository.findAllByRegisterNameNotNull()).thenReturn(registers);

        BalanceResponse actual = balanceService.getBalanceForAllRegisters();

        assertThat(actual.getRegisters()).isEqualTo(registers);
    }
}