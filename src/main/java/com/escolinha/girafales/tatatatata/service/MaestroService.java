package com.escolinha.girafales.tatatatata.service;

import com.escolinha.girafales.tatatatata.dto.HorasMaestroDTO;
import com.escolinha.girafales.tatatatata.repository.MaestroRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaestroService {
    
    private final MaestroRepository maestroRepository;

    public MaestroService(MaestroRepository maestroRepository) {
        this.maestroRepository = maestroRepository;
    }

    public List<HorasMaestroDTO> getHorasMaestro() {
        return maestroRepository.horasPorMaestro().stream()
            .map(result -> {
                HorasMaestroDTO dto = new HorasMaestroDTO();
                dto.setProfessorName((String) result[0]);
                
                Double hours = result[1] != null 
                ? ((BigDecimal) result[1]).doubleValue() 
                : 0.0;
                dto.setTotalHours(hours);
                return dto;
        }).collect(Collectors.toList());
    }
}