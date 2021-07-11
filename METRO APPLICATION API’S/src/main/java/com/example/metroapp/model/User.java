package com.example.metroapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicInsert
public class User {
    private Integer user_id;
    private String user_name;
    private String email;
    private String password;
    private Integer balance;
    private Set<Ticket> tickets = new HashSet<>();


    public User(){
    }

    public User(Integer user_id, String user_name, String email, String password, Integer balance) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }


    @OneToMany(mappedBy="user")
    @JsonManagedReference
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> InputTickets) {
        tickets.addAll(InputTickets);
    }
}

