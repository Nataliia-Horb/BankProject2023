package com.project.bankproj.repository;

import com.project.bankproj.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    Optional<Account> findAccountById(UUID id);

    @Query("SELECT a, b FROM Account a JOIN a.agreements b WHERE b.product.id=:id ")
    List<Account> findAccountsWhereProductId(int id);
}