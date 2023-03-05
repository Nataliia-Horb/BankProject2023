package com.project.bankproj.entity;

import com.project.bankproj.entity.enums.AgreementStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "agreement")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "account", "product"})
@ToString
public class Agreement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private AgreementStatus status;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne()
    @JoinColumn(name = "account_id",
            referencedColumnName = "id")
    private Account account;

    @ManyToOne()
    @JoinColumn(name = "product_id",
            referencedColumnName = "id")
    private Product product;
}