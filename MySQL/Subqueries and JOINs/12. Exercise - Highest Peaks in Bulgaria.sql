SELECT c.`country_code`,m.`mountain_range`,p.`peak_name`,p.`elevation`
FROM `peaks` AS p
JOIN `mountains` AS m ON m.`id` = p.`mountain_id`
JOIN `mountains_countries` AS mc ON mc.`mountain_id` = m.`id`
JOIN `countries` AS c ON  c.`country_code` = mc.`country_code`
WHERE p.`elevation` > 2835 AND c.`country_code` IN ('BG')
ORDER BY p.`elevation` DESC