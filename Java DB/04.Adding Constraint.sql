ALTER TABLE `products`
ADD CONSTRAINT `index`
FOREIGN KEY `products` (`category_id`)
REFERENCES `categories`(`id`);