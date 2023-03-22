package com.project.bankproj.repository;

import com.project.bankproj.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Integer> {

    @Override
    void deleteById(Integer integer);
}