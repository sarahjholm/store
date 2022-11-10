CREATE TABLE IF NOT EXISTS `brands` (
  `brands_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` VARCHAR(30));

CREATE TABLE IF NOT EXISTS `prices` (
  `price_list` int AUTO_INCREMENT  PRIMARY KEY, `base_price` INT,
  `start_date` TIMESTAMP, `end_date` TIMESTAMP, `product_id` INT, `priority` INT, `price` DOUBLE,
  `curr` VARCHAR(4), `brands_id` INT AUTO_INCREMENT, FOREIGN KEY (brands_id) REFERENCES brands(brands_id));