package com.project.bankproj.entity;

import com.project.bankproj.entity.enums.AgreementStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "agreement")
@NoArgsConstructor
@AllArgsConstructor
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

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private Timestamp createdAt;

    @CreationTimestamp
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agreement agreement = (Agreement) o;
        return id == agreement.id && Objects.equals(createdAt, agreement.createdAt) &&
                Objects.equals(account, agreement.account) && Objects.equals(product, agreement.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, account, product);
    }
}