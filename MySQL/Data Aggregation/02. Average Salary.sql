SELECT `department_id`,ROUND(avg(`salary`),2) AS "Average Salary`"
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;