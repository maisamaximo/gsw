package com.atm.repository;

import java.util.List;

import com.atm.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    List<Bank> findBankByBankName(String bankName);

    Bank save(Bank newAccount);

}
