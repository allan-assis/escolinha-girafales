package com.escolinha.girafales.tatatatata.model;

import jakarta.persistence.*;

@Entity
public class SubjectPrerequisite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    
    @ManyToOne
    @JoinColumn(name = "prerequisite_id")
    private Subject prerequisite;
}