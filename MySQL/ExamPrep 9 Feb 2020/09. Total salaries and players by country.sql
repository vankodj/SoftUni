SELECT c.`name`, COUNT(p.`id`) AS 'total_count_of_player',
 SUM(p.`salary`) AS 'total_sum_of_salaries'
FROM `countries` AS c
LEFT JOIN `towns` AS tw ON tw.`country_id` = c.`id`
LEFT JOIN `stadiums` AS s ON s.`town_id` = tw.`id`
LEFT JOIN `teams` AS t ON t.`stadium_id` = s.`id`
LEFT JOIN `players` As p ON p.`team_id` = t.`id`
GROUP BY c.`id`
ORDER BY `total_count_of_player` DESC, c.`name` ASC