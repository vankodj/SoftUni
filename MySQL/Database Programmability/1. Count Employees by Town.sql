CREATE FUNCTION ufn_count_employees_by_town(name_town VARCHAR(50))
RETURNS INT 
DETERMINISTIC
BEGIN
RETURN
(SELECT COUNT(*)
FROM `employees` AS e
JOIN `addresses` AS a ON a.`address_id` = e.`address_id`
JOIN `towns` AS t ON t.`town_id` = a.`town_id`
WHERE t.`name` IN (name_town));
END