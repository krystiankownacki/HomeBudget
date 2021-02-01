package com.krystiankownacki.homebudget.repository.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Getter
@Entity
@Table(name = "REGISTERS")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "NUMERIC(19,0)")
    private Long id;

    @Column(name = "REGISTER_NAME")
    private String registerName;

    @Column(name = "BALANCE")
    private int balance;

    public void recharge(int amount) {
        this.balance += amount;
    }

    public boolean canAfford(int amount) {
        return balance > amount;
    }
}
