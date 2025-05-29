package com.escolinha.girafales.tatatatata.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "building")
    private List<Room> rooms;
}