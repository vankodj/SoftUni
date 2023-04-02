CREATE TABLE deleted_employees
(employee_id INT PRIMARY KEY AUTO_INCREMENT,
 first_name VARCHAR(50) NOT NULL,
 last_name VARCHAR(50) NOT NULL,
 middle_name VARCHAR(50)NOT NULL,
 job_title VARCHAR(50)NOT NULL,
 department_id INT NOT NULL,
 salary DECIMAL (19,4) NOT NULL);
 
 CREATE TRIGGER tr_deleted_employees
 AFTER DELETE ON `employees`
 FOR EACH ROW
 BEGIN
 INSERT INTO `deleted_employees`
 VALUES(employee_id,
        OLD.first_name,
        OLD.last_name,
        OLD.middle_name,
        OLD.job_title,
        OLD.department_id,
        OLD.salary);
 
 END