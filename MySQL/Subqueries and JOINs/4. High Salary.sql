SELECT COUNT(*) 
FROM `employees`
WHERE `employees`.`salary` > (SELECT AVG(`employees`.`salary`)
FROM `employees`);