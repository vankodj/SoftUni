SELECT `addresses`.`town_id`,`towns`.`name`,`addresses`.`address_text`
FROM `addresses`
JOIN `towns` ON `addresses`.`town_id` = `towns`.`town_id`
WHERE `towns`.`name` IN ('San Francisco', 'Sofia','Carnation')
ORDER BY `towns`.`town_id`,`addresses`.`address_id`;