SELECT `e`.`first_name`,`e`.`last_name`,`e`.`hire_date`,`d`.`name`
FROM `employees` AS e
JOIN `departments` AS d ON `d`.`department_id` = `e`.`department_id`
WHERE `e`.`hire_date` >  1999/1/1 AND `d`.`name` IN ('Sales','Finance')
ORDER BY `e`.`hire_date` ASC