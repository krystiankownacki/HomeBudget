package com.krystiankownacki.homebudget.repository.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Entity
@Table(name = "REGISTERS")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
