DELETE c FROM `clients` AS c
LEFT JOIN `courses` As co ON co.`client_id` = c.`id`
WHERE co.`client_id` IS NULL AND CHAR_LENGTH(c.`full_name`) >3;