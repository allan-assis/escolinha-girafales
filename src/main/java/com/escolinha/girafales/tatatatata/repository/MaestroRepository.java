package com.escolinha.girafales.tatatatata.repository;

import com.escolinha.girafales.tatatatata.model.Professor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MaestroRepository extends CrudRepository<Professor, Long> {

    @Query(value =
       "SELECT p.name AS professorName, " +
       "SUM( " +
       "  (EXTRACT(HOUR FROM cs.end_time) * 60 " +
       "   + EXTRACT(MINUTE FROM cs.end_time) " +
       "   - EXTRACT(HOUR FROM cs.start_time) * 60 " +
       "   - EXTRACT(MINUTE FROM cs.start_time) " +
       "  ) / 60.0" +
       ") AS totalHours " +
       "FROM professor p " +
       "JOIN subject s ON p.id = s.professor_id " +
       "JOIN \"class\" c ON s.id = c.subject_id " +
       "JOIN class_schedule cs ON c.id = cs.class_id " +
       "GROUP BY p.name",
       nativeQuery = true)
    List<Object[]> horasPorMaestro();
}
