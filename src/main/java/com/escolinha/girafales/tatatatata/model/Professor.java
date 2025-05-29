package com.escolinha.girafales.tatatatata.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    
    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;
    
    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<Subject> subjects;
}