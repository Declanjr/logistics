package com.auca.logistics.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Getter;

@Getter
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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    // Constructor to automatically set STAFF role
    public MyAppUser() {
        this.roles.add(Role.STAFF);
    }

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}