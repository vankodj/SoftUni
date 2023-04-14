SELECT c.`full_name`,COUNT(co.`car_id`) AS 'count_of_cars',
SUM(co.`bill`) AS 'total_sum'
FROM `clients` As c
JOIN `courses` As co ON co.`client_id` = c.`id`
WHERE REGEXP_LIKE(c.`full_name`, '^.a') 
GROUP BY c.`id`
HAVING count_of_cars >1
ORDER BY c.`full_name`