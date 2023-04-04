CREATE PROCEDURE usp_get_towns_starting_with(starting_with VARCHAR(50))
BEGIN
  SELECT `name`
  FROM `towns`
  WHERE `name` LIKE CONCAT(starting_with,'%') 
  ORDER BY `name` ASC;
END