SELECT `department_id`, count(`id`) AS "Number of employee"
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`,`Number of employee`;