CREATE table employees(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
first_name VARCHAR(50),
last_name VARCHAR(50));
CREATE table categories(
`id` INT primary KEY auto_increment NOT NULL,
`name` VARCHAR(50) NOT NULL);
CREATE TABLE products(
`id` INT PRIMARY KEY auto_increment NOT NULL,
`name` varchar(50) NOT NULL,
`category_id` INT NOT NULL);