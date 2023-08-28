package ru.fintechwizards.finwiz.models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;

    private String name;
    private String address;

    public Bank() {}

    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
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
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}