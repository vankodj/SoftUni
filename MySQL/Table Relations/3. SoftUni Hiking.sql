SELECT `starting_point` AS 'route_starting_point',
`end_point` AS 'route_ending_point',
`leader_id`,
concat(`first_name`, ' ',`last_name`)
FROM `routes` 
JOIN `campers` ON routes.leader_id = campers.id;