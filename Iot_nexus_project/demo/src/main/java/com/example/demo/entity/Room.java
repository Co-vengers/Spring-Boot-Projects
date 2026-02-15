package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String floor;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Device> devices;
}
