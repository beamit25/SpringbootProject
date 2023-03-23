package com.wallet.application;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.*;
import java.time.LocalDate;// add
@Entity
@PropertySource("classpath:application.properties")
public class WalletDto {
    @Id
    @GeneratedValue
    private Integer id;
    @Transient
    String jwt;
    @NotBlank(message = "Name cant be null, it should contain chars")
    @Pattern(regexp = "[a-zA-Z]{3,16}", message = "Name should contain min 3 & max 16 chars , no digits and special chars allowed.")
    private String name;

    private Double balance;

    private String email;
    private String password;
    private String role;

    public WalletDto(Integer id, String name, Double balance, String email,String password,String role, String jwt) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.role= role;
        this.jwt=jwt;
    }

    public WalletDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() { return password;  }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +

                '}';
    }
}
