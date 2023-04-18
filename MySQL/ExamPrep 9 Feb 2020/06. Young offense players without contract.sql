SELECT p.`id`,CONCAT(p.`first_name`,' ',p.`last_name`),
p.`age`,p.`position`,p.`hire_date`
FROM `players` AS p
JOIN `skills_data` as sd ON sd.`id` = p.`skills_data_id`
WHERE `age` <23 
AND `position` = 'A' 
AND `hire_date` IS NULL
AND sd.`strength` >50
ORDER BY p.`salary` ASC, p.`age` ASC;