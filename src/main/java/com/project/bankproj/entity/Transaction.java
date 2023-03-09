package com.project.bankproj.entity;

import com.project.bankproj.entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID", strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private TransactionType type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private Timestamp createdAt;

    @ManyToOne()
    @JoinColumn(name = "debit_account_id",
            referencedColumnName = "id")
    private Account debitAccountId;

    @ManyToOne()
    @JoinColumn(name = "credit_account_id",
            referencedColumnName = "id")
    private Account creditAccountId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(debitAccountId, that.debitAccountId) &&
                Objects.equals(creditAccountId, that.creditAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, debitAccountId, creditAccountId);
    }
}