CREATE FUNCTION udf_stadium_players_count(stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE counts INT;
SET counts :=(SELECT count(p.`id`)
FROM `players` AS p
RIGHT JOIN `teams` AS t ON t.`id` = p.`team_id`
RIGHT JOIN `stadiums` AS s ON s.`id` = t.`stadium_id`
WHERE s.`name` = stadium_name
GROUP BY s.`id`);
RETURN counts;
END