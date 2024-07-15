package com.aiyuns.tinkerplay.Controller.Service.ServiceImpl.Dao.Repository;

import com.aiyuns.tinkerplay.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(String accountNumber);
}
