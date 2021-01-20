package com.krystiankownacki.homebudget.service;

import com.krystiankownacki.homebudget.domain.exception.RegisterNotFoundException;
import com.krystiankownacki.homebudget.repository.RegisterRepository;
import com.krystiankownacki.homebudget.repository.entity.Register;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegisterDatabaseService {

    private final RegisterRepository registerRepository;

    public Register findByName(String name) {
        log.debug("Fetching Register with name: {}", name);
        Optional<Register> optionalRegister = registerRepository.findByRegisterName(name);
        return optionalRegister.orElseThrow(() -> new RegisterNotFoundException(name));
    }
}
