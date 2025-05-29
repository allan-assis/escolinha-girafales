package com.escolinha.girafales.tatatatata.service;

import com.escolinha.girafales.tatatatata.dto.HorasSalaDTO;
import com.escolinha.girafales.tatatatata.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalaService {
    
    private final SalaRepository roomRepository;

    public SalaService(SalaRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<HorasSalaDTO> getRoomSchedules() {
        List<HorasSalaDTO> schedules = new ArrayList<>();
        
        roomRepository.horasPorSala().forEach(row -> {
            String sala = (String) row[0];
            String bloco = (String) row[1];
            Number dia = (Number) row[2];  
            Object comeca = row[3];  
            Object termina = row[4];  

            HorasSalaDTO dto = new HorasSalaDTO();
            dto.setRoomName(sala);
            dto.setBuildingName(bloco);

            if (dia != null) {
                dto.setDayOfWeek(dia.intValue());
                dto.setStartTime(
                comeca instanceof java.time.LocalTime
                    ? java.sql.Time.valueOf((java.time.LocalTime) comeca)
                    : (java.sql.Time) comeca
                );
                dto.setEndTime(
                termina   instanceof java.time.LocalTime
                    ? java.sql.Time.valueOf((java.time.LocalTime) termina)
                    : (java.sql.Time) termina
                );
                dto.setStatus("Ocupado");
            } else {
                dto.setStatus("Livre");
                dto.setDayOfWeek(0);
                dto.setStartTime(Time.valueOf("00:00:00"));
                dto.setEndTime(  Time.valueOf("00:00:00"));

            }

            schedules.add(dto);
        });

        return schedules;
    }
}