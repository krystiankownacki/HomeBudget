package com.krystiankownacki.homebudget.repository;

import com.krystiankownacki.homebudget.domain.dto.RegisterDto;
import com.krystiankownacki.homebudget.repository.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {

    Optional<Register> findByRegisterName(String registerName);
    List<RegisterDto> findAllByRegisterNameNotNull();
}
