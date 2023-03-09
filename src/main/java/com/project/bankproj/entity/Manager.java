package com.project.bankproj.entity;

import com.project.bankproj.entity.enums.ManagerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "manager")
@NoArgsConstructor
@AllArgsConstructor
public class Manager {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private ManagerStatus status;

    @Column(name = "created_at")
    public Timestamp createdAt;

    @Column(name = "updated_at")
    public Timestamp updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id == manager.id && Objects.equals(firstName, manager.firstName) &&
                Objects.equals(lastName, manager.lastName) && Objects.equals(createdAt, manager.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, createdAt);
    }
}