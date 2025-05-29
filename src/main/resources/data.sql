-- Limpar dados anteriores
DELETE FROM class_schedule;
DELETE FROM "class";
DELETE FROM subject;
DELETE FROM professor;
DELETE FROM title;
DELETE FROM department;
DELETE FROM room;
DELETE FROM building;

-- Departamentos
INSERT INTO department (id, name) VALUES 
 (1, 'Matemática'),
 (2, 'Artes'),
 (3, 'Música');

-- Títulos
INSERT INTO title (id, name) VALUES
 (1, 'Professor'),
 (2, 'Maestro'),
 (3, 'Maestro Linguiça');

-- Professores
INSERT INTO professor (id, name, department_id, title_id) VALUES
 (1, 'Girafales', 1, 3),
 (2, 'Seu Madruga', 2, 1),
 (3, 'Chapolin',    3, 2);

-- Prédios
INSERT INTO building (id, name) VALUES
 (1, 'Bloco A'),
 (2, 'Bloco B'),
 (3, 'Bloco C');

-- Salas
INSERT INTO room (id, building_id, name) VALUES
 (1, 1, 'Sala 1'),
 (2, 1, 'Sala 2'),
 (3, 2, 'Sala 3'),
 (4, 3, 'Pátio da Escola');

-- Disciplinas
INSERT INTO subject (id, code, name, professor_id) VALUES
 (1, 'ART-101', 'Aritimética',   1),
 (2, 'DES-201', 'Desenho',  2),
 (3, 'MUS-301', 'Música',  3);

-- Turmas
INSERT INTO "class" (id, "year", semester, code, subject_id) VALUES
 (1, 2025, 1, 'T01', 1),
 (2, 2025, 1, 'T02', 2),
 (3, 2025, 1, 'T03', 3);

-- Horários
INSERT INTO class_schedule (id, class_id, room_id, day_of_week, start_time, end_time) VALUES
 (1, 1, 1, 1, '08:00:00', '10:00:00'),
 (2, 2, 3, 3, '14:00:00', '16:00:00'),
 (3, 3, 4, 4, '10:00:00', '12:00:00');
