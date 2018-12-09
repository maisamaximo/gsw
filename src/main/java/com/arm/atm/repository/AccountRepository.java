package com.arm.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arm.atm.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByAccountNumberAndAccountPassword(String accountNumber, String accountPassword);

	Account save(Account newAccount);
}
