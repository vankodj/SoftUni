CREATE table `users`
(`id` INT AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` TIME, 
`is_deleted` BOOLEAN,
CONSTRAINT pk_users 
    PRIMARY KEY `users`(`id`)
);
INSERT INTO `users`(`username`,`password`)
VALUES ('Test1','PASS'),
('Test2','PASS'),
('Test3','PASS'),
('Test4','PASS'),
('Test5','PASS');