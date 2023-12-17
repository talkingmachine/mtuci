#### Создаем 3 таблицы и описываем их поля

CREATE TABLE students (
  id INTEGER PRIMARY KEY,
  name VARCHAR(255),
  group_id INTEGER NOT NULL
);

CREATE TABLE student_marks (
  student_id INTEGER PRIMARY KEY,
  math_mark_average FLOAT,
  physics_mark_average FLOAT,
  python_mark_average FLOAT
);

CREATE TABLE groups (
  id INTEGER PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255)
);

#### Заполним таблицы данными

INSERT INTO groups (id, name, description) VALUES
(0, 'БПИ2301', 'Описание для Группы БПИ2301'),
(1, 'БПИ2302', 'Описание для Группы БПИ2302'),
(2, 'БПИ2303', 'Описание для Группы БПИ2303'),
(3, 'БПИ2304', 'Описание для Группы БПИ2304'),
(4, 'БПИ2305', 'Описание для Группы БПИ2305'),
(5, 'БПИ2306', 'Описание для Группы БПИ2306');

INSERT INTO students (id, name, group_id) VALUES
(0, 'Студент 1', 1),
(1, 'Студент 2', 1),
(2, 'Студент 3', 3),
(3, 'Студент 4', 3),
(4, 'Студент 5', 5);

INSERT INTO student_marks (student_id, math_mark_average, physics_mark_average, python_mark_average) VALUES
(0, 3.0, 4.0, 2.0),
(1, 4.0, 5.0, 5.0),
(2, 3.0, 5.0, 4.0),
(3, 3.0, 2.0, 5.0),
(4, 5.0, 3.0, 5.0);

#### Сделаем несколько простых запросов к получившейся базе данных

SELECT id, name FROM students WHERE group_id = 3;
(id и имя студентов из группы БПИ2304)

SELECT * FROM student_marks WHERE physics_mark_average > 4;
(оценки студентов со средним баллом за физику выше 4)

SELECT * FROM groups WHERE name = 'БПИ2306';
(информация о группе БПИ2306)