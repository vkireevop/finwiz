package ru.fintechwizards.finwiz.models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;

    private String name;
    private String country;

    public Bank() {}

    public Bank(String name, String address) {
        this.name = name;
        this.country = address;
    }

    public Long getBankId() {
        return bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return country;
    }

    public void setAddress(String address) {
        this.country = address;
    }
}