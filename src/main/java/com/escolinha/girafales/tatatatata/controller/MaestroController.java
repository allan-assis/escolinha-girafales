package com.escolinha.girafales.tatatatata.controller;

import com.escolinha.girafales.tatatatata.dto.HorasMaestroDTO;
import com.escolinha.girafales.tatatatata.service.MaestroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maestros")
public class MaestroController {
    
    private final MaestroService maestroService;

    public MaestroController(MaestroService maestroService) {
        this.maestroService = maestroService;
    }

    @GetMapping("/horas")
    public List<HorasMaestroDTO> getHorasMaestros() {
        return maestroService.getHorasMaestro();
    }
}