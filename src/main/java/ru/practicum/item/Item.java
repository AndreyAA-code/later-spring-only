package ru.practicum.item;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "items")
class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    private String url;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="tags", joinColumns=@JoinColumn(name="item_id"))
    @Column(name="name")
    private Set<String> tags = new HashSet<>();

}