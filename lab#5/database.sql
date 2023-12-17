DROP TABLE IF EXISTS 'students';
DROP TABLE IF EXISTS 'student_marks';
DROP TABLE IF EXISTS 'groups';
CREATE TABLE students (
  id INTEGER PRIMARY KEY,
  name VARCHAR(255),
  group_id INTEGER NOT NULL
);
INSERT INTO 'students' VALUES(0,'Студент 1',1);
INSERT INTO 'students' VALUES(1,'Студент 2',1);
INSERT INTO 'students' VALUES(2,'Студент 3',3);
INSERT INTO 'students' VALUES(3,'Студент 4',3);
INSERT INTO 'students' VALUES(4,'Студент 5',5);
CREATE TABLE student_marks (
  student_id INTEGER PRIMARY KEY,
  math_mark_average FLOAT,
  physics_mark_average FLOAT,
  python_mark_average FLOAT
);
INSERT INTO 'student_marks' VALUES(0,3,4,2);
INSERT INTO 'student_marks' VALUES(1,4,5,5);
INSERT INTO 'student_marks' VALUES(2,3,5,4);
INSERT INTO 'student_marks' VALUES(3,3,2,5);
INSERT INTO 'student_marks' VALUES(4,5,3,5);
CREATE TABLE groups (
  id INTEGER PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255)
);
INSERT INTO 'groups' VALUES(0,'БПИ2301','Описание для Группы БПИ2301');
INSERT INTO 'groups' VALUES(1,'БПИ2302','Описание для Группы БПИ2302');
INSERT INTO 'groups' VALUES(2,'БПИ2303','Описание для Группы БПИ2303');
INSERT INTO 'groups' VALUES(3,'БПИ2304','Описание для Группы БПИ2304');
INSERT INTO 'groups' VALUES(4,'БПИ2305','Описание для Группы БПИ2305');
INSERT INTO 'groups' VALUES(5,'БПИ2306','Описание для Группы БПИ2306');
