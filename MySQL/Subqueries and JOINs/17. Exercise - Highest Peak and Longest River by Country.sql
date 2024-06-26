SELECT c.`country_name`,MAX(p.`elevation`) AS 'highest_peak_elevation',
MAX(r.`length`) AS 'longest_river_length'
FROM `countries` AS c
lEFT JOIN `mountains_countries` AS mc ON mc.`country_code` = c.`country_code`
LEFT JOIN `peaks` As p ON p.`mountain_id` = mc.`mountain_id`
LEFT JOIN `countries_rivers` AS cr ON cr.`country_code` = c.`country_code`
LEFT JOIN `rivers` AS r ON r.`id` = cr.`river_id`
GROUP BY c.`country_name`
ORDER BY `highest_peak_elevation` DESC, `longest_river_length` DESC
LIMIT 5;