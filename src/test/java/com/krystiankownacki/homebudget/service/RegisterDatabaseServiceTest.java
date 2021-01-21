package com.krystiankownacki.homebudget.service;

import com.krystiankownacki.homebudget.domain.exception.RegisterNotFoundException;
import com.krystiankownacki.homebudget.repository.RegisterRepository;
import com.krystiankownacki.homebudget.repository.entity.Register;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterDatabaseServiceTest {

    private static final String NAME = "foo";

    @Mock
    private Register register;

    @Mock
    private RegisterRepository registerRepository;

    @InjectMocks
    private RegisterDatabaseService registerDatabaseService;

    @Test
    void shouldFindByName() {
        when(registerRepository.findByRegisterName(NAME)).thenReturn(Optional.of(register));

        Register actual = registerDatabaseService.findByName(NAME);

        assertThat(actual).isEqualTo(register);
    }

    @Test
    void shouldThrowExceptionWhenRegisterNotFound() {
        when(registerRepository.findByRegisterName(NAME)).thenReturn(Optional.empty());

        assertThrows(RegisterNotFoundException.class, () -> registerDatabaseService.findByName(NAME));
    }
}