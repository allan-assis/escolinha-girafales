package com.escolinha.girafales.tatatatata.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    
    @OneToMany(mappedBy = "room")
    private List<ClassSchedule> schedules;
}