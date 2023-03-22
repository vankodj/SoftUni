CREATE TABLE students(
`student_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);
INSERT INTO `students` (`student_id`, `name`) 
VALUES 
    (1, 'Mila'), 
    (2, 'Toni'), 
    (3, 'Ron');

CREATE TABLE exams(
`exam_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);
INSERT INTO `exams` (`exam_id`, `name`) 
VALUES 
    (101, 'Spring MVC'), 
    (102, 'Neo4j'), 
    (103, 'Oracle 11g');

CREATE TABLE students_exams(
`student_id` INT,
CONSTRAINT fk_se_s
FOREIGN KEY (`student_id`)
REFERENCES `students`(`student_id`),
`exam_id` INT,
CONSTRAINT fk_se_e
FOREIGN KEY (`exam_id`)
REFERENCES `exams`(`exam_id`)
);
INSERT INTO `students_exams` (`student_id`, `exam_id`) 
VALUES 
    (1, 101),
    (1, 102),
    (2, 101),
    (3, 103),
    (2, 102),
    (2, 103);