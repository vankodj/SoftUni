SELECT `name`,date_format(`start`, '%Y-%m-%d') AS `start`
FROM `games`
WHERE year(`start`) = 2011 OR year(`start`)= 2012
ORDER BY `start`,`name`
LIMIT 50;