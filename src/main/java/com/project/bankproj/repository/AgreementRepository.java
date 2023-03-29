package com.project.bankproj.repository;

import com.project.bankproj.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AgreementRepository extends JpaRepository<Agreement, Integer> {

    @Override
    void deleteById(@Param("integer") Integer integer);
}