CREATE TABLE `directors`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);
INSERT INTO `directors`(`director_name`,`notes`) VALUES
("director1","testnotes"),
("director2","testnotes"),
("director3","testnotes"),
("director4","testnotes"),
("director5","testnotes");

CREATE TABLE `genres`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(50) NOT NULL,
`notes` TEXT);

INSERT INTO `genres`(`genre_name`,`notes`) VALUES
("genre1","testnotes"),
("genre2","testnotes"),
("genre3","testnotes"),
("genre4","testnotes"),
("genre5","testnotes");

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(50) NOT NULL,
`notes` TEXT);

INSERT INTO `categories`(`category_name`,`notes`) VALUES
("cat1","testnotes"),
("cat2","testnotes"),
("cat3","testnotes"),
("cat4","testnotes"),
("cat5","testnotes");

CREATE TABLE `movies`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL,
`director_id` INT,
`copyright_year` INT,
`length` INT,
`genre_id` INT,
`category_id` INT,
`rating` DOUBLE,
`notes` TEXT);

INSERT INTO `movies` (`title`) VALUES
("movie1"),
("movie2"),
("movie3"),
("movie4"),
("movie5");