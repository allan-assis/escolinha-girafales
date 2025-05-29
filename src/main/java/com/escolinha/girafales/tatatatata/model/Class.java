package com.escolinha.girafales.tatatatata.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "\"class\"")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer year;
    private Integer semester;
    private String code;
    
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    
    @OneToMany(mappedBy = "classObj")
    private List<ClassSchedule> schedules;
}