SELECT c.`name`, COUNT(m.`id`) AS 'movies_count'
 FROM `countries` AS c
 JOIN `movies` AS m ON m.`country_id` = c.`id`
 GROUP BY c.`id`
 HAVING `movies_count` >=7
 ORDER BY c.`name` DESC;