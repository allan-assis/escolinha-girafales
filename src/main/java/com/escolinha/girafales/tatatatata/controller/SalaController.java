package com.escolinha.girafales.tatatatata.controller;

import com.escolinha.girafales.tatatatata.dto.HorasSalaDTO;
import com.escolinha.girafales.tatatatata.service.SalaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {
    
    private final SalaService roomService;

    public SalaController(SalaService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/horarios")
    public List<HorasSalaDTO> getHorariosSalas() {
        return roomService.getRoomSchedules();
    }
}