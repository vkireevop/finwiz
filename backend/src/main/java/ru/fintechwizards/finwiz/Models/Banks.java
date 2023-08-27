package ru.fintechwizards.finwiz.Models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "banks")
public class Banks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;

    private String name;
    private String address;
}