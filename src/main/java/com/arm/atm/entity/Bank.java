package com.arm.atm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String bankName;

    public Bank(){}

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public Long getId() {
        return id;
    }

    public String getBankName() {
        return bankName;
    }
}
