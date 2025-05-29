package com.escolinha.girafales.tatatatata.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    
    @OneToMany(mappedBy = "subject")
    private List<Class> classes;
    
    @OneToMany(mappedBy = "subject")
    private List<SubjectPrerequisite> prerequisites;
}