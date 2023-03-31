SELECT c.`country_code`,count(m.`mountain_range`) AS 'mountain_range'
FROM `mountains` AS m
JOIN `mountains_countries` AS mc ON mc.`mountain_id` = m.`id`
JOIN `countries` AS c ON  c.`country_code` = mc.`country_code`
WHERE c.`country_code` IN ('BG','RU','US')
group by c.`country_code`
ORDER BY `mountain_range` DESC