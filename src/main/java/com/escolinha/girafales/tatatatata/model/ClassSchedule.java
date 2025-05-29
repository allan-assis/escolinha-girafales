package com.escolinha.girafales.tatatatata.model;

import jakarta.persistence.*;
import java.sql.Time;

@Entity
public class ClassSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class classObj; 
    
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    
    private Integer dayOfWeek; // 0: SEGUNDA ~ 5: SEXTA
    private Time startTime;
    private Time endTime;
}