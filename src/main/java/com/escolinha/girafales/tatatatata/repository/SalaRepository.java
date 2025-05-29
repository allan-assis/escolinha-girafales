package com.escolinha.girafales.tatatatata.repository;

import com.escolinha.girafales.tatatatata.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalaRepository extends CrudRepository<Room, Long> {
    
    @Query(value = "SELECT r.name AS roomName, b.name AS buildingName, " +
       "cs.day_of_week, cs.start_time, cs.end_time " +
       "FROM room r " +
       "JOIN building b ON r.building_id = b.id " +
       "LEFT JOIN class_schedule cs ON r.id = cs.room_id", nativeQuery = true)
    List<Object[]> horasPorSala();
}