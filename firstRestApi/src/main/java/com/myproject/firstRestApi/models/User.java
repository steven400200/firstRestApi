package com.myproject.firstRestApi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Column(name = "last_name")
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;


    @JsonIgnore
    public boolean isEmpty() {
        return (id == null) && (name == null || name.isBlank()) &&
                (lastName == null || lastName.isBlank()) &&
                (email == null || email.isBlank()) &&
                (phoneNumber == null || phoneNumber.isBlank());
    }
}
