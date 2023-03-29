package com.project.bankproj.entity;

import com.project.bankproj.entity.enums.AccountStatus;
import com.project.bankproj.entity.enums.AccountType;
import com.project.bankproj.entity.enums.Currencies;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID", strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private AccountType type;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "currency_code")
    @Enumerated(EnumType.ORDINAL)
    private Currencies currency_code;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id",
            referencedColumnName = "id")
    private Client client;

    @OneToMany(cascade = {MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY, mappedBy = "account")
    private Set<Agreement> agreements;

    @OneToMany(cascade = {MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY, mappedBy = "debitAccountId")
    private Set<Transaction> debitTransactions;

    @OneToMany(cascade = {MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY, mappedBy = "creditAccountId")
    private Set<Transaction> creditTransactions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && currency_code == account.currency_code &&
                Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currency_code, client);
    }
}