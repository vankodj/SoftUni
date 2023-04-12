CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
 RETURNS INT
 DETERMINISTIC
 BEGIN
 RETURN (SELECT COUNT(g.`id`)
 FROM `actors` AS a
 JOIN `movies_actors` AS am ON am.`actor_id` = a.`id`
 JOIN `genres_movies` AS gm ON gm.`movie_id` = am.`movie_id`
 JOIN `genres` AS g ON gm.`genre_id` = g.`id`
 WHERE `full_name` = CONCAT(a.`first_name`,' ',`last_name`) 
 AND g.`name` = 'History' 
 GROUP BY g.`id`);
 END