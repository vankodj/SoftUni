SELECT c.`id` AS 'car_id', c.`make`,c.`mileage`,
COUNT(co.`id`) AS count,
ROUND(AVG(co.`bill`),2) AS 'avg_bill'
FROM `cars` AS c
LEFT JOIN `courses` AS co ON co.`car_id` = c.`id`
GROUP BY c.`id`
HAVING count !=2
ORDER BY count DESC, c.`id`;