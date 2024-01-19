package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"first_name", "last_name"})
})
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @NonNull
    @NotBlank(message = "First name is not blank")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NonNull
    @NotBlank(message = "Last name is not blank")
    private String lastName;

    @Column(name = "age", nullable = false)
    @NonNull
    private int age;
}
