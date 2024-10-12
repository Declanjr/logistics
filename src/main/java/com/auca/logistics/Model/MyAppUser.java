package com.auca.logistics.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MyAppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private Date date;
    private int number;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Role role;

    public MyAppUser() {
        this.role = Role.STAFF; // Set the default role here
    }

}