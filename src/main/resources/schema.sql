-- Criação das tabelas

CREATE TABLE department (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE title (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE professor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    department_id INT NOT NULL,
    title_id INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (title_id) REFERENCES title(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE building (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE room (
    id INT PRIMARY KEY AUTO_INCREMENT,
    building_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    FOREIGN KEY (building_id) REFERENCES building(id) ON DELETE CASCADE ON UPDATE CASCADE,
    UNIQUE (building_id, name)
);

CREATE TABLE subject (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    professor_id INT NOT NULL,
    FOREIGN KEY (professor_id) REFERENCES professor(id) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE "class" (
    id INT PRIMARY KEY AUTO_INCREMENT,
    "year" INT NOT NULL CHECK ("year" >= 2000),
    semester INT NOT NULL CHECK (semester IN (1, 2)),
    code VARCHAR(20) NOT NULL,
    subject_id INT NOT NULL,
    FOREIGN KEY (subject_id) REFERENCES subject(id) ON DELETE CASCADE ON UPDATE CASCADE,
    UNIQUE ("year", semester, code)
);

CREATE TABLE class_schedule (
    id INT PRIMARY KEY AUTO_INCREMENT,
    class_id INT NOT NULL,
    room_id INT NOT NULL,
    day_of_week INT NOT NULL CHECK (day_of_week BETWEEN 1 AND 7),
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    FOREIGN KEY (class_id) REFERENCES "class"(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (room_id) REFERENCES room(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CHECK (start_time < end_time)
);
