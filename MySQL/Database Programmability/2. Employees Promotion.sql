CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR (50))
BEGIN
UPDATE `employees` SET `salary` = `salary` * 1.05
WHERE  `department_id` = (SELECT `department_id` FROM `departments`
WHERE `name` = department_name);
END