package com.project.bankproj.entity;

import com.project.bankproj.entity.enums.ManagerStatus;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "manager")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "createdAt"})
@ToString
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

}