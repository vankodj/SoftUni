ALTER table `users`
DROP primary key,
ADD CONSTRAINT pk_users_2
PRIMARY KEY `users`(`id`, `username`);