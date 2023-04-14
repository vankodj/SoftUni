CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100)) 
BEGIN
SELECT a.`name`,c.`full_name` AS 'full_names',
(CASE
WHEN co.`bill` <=20 THEN 'Low'
WHEN co.`bill` <=30 THEN 'Medium'
WHEN co.`bill` >30 THEN 'High'
END),cars.`make`,cars.`condition`,cat.`name`
FROM addresses AS a
JOIN courses AS co ON co.`from_address_id` = a.`id`
JOIN clients AS c ON c.`id` = co.`client_id`
JOIN cars ON cars.`id` = co.`car_id`
JOIN categories AS cat ON cat.`id` = cars.`category_id`
WHERE a.`name` = address_name
ORDER BY cars.`make`, c.`full_name`;
END