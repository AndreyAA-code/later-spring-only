package ru.practicum.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usera")
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
}