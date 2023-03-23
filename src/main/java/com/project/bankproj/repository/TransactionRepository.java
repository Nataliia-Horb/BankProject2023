package com.project.bankproj.repository;

import com.project.bankproj.entity.Product;
import com.project.bankproj.entity.Transaction;
import com.project.bankproj.entity.enums.Currencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Product, Currencies> {

    @Query("from Transaction t where t.creditAccountId.currency_code =:currency " +
            "or t.debitAccountId.currency_code =:currency")
    List<Transaction> findTransactionsWhereCurrencies(Currencies currency);
}