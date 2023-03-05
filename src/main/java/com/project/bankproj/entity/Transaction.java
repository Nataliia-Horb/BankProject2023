package com.project.bankproj.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "createdAt", "debitAccountId", "creditAccountId"})
@ToString
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID", strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "type")
    private int type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Timestamp createdAt; //дата

    @ManyToOne()
    @JoinColumn(name = "debit_account_id",
            referencedColumnName = "id")
    private Account debitAccountId;

    @ManyToOne()
    @JoinColumn(name = "credit_account_id",
            referencedColumnName = "id")
    private Account creditAccountId;

}