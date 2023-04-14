CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20))
RETURNS INT 
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(co.`id`)
FROM `courses` As co
JOIN `clients`  As c ON c.`id` = co.`client_id`
WHERE c.`phone_number` = phone_num
GROUP BY c.`id`

);
END