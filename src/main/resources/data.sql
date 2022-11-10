INSERT INTO `brands` (`name`) VALUES('LOJA');
INSERT INTO `brands` (`name`) VALUES('LOJA2');
INSERT INTO `brands` (`name`) VALUES('LOJA3');
INSERT INTO `brands` (`name`) VALUES('LOJA4');
INSERT INTO `prices` (`base_price`, `start_date`, `end_date`, `product_id`, `priority`, `price`, `curr`, `brands_id`)
    VALUES(1, '2020-06-14 00.00.00', '2020-12-31 23.59.59', 35455, 0, 35.50, 'EUR', 1);
INSERT INTO `prices` (`base_price`, `start_date`, `end_date`, `product_id`, `priority`, `price`, `curr`, `brands_id`)
    VALUES(1, '2020-06-14 15.00.00', '2020-06-14 18.30.00', 35455, 1, 25.45, 'EUR', 1);
INSERT INTO `prices` (`base_price`, `start_date`, `end_date`, `product_id`, `priority`, `price`, `curr`, `brands_id`)
    VALUES(1, '2020-06-15 00.00.00', '2020-06-15 11.00.00', 35455, 1, 30.50, 'EUR', 1);
INSERT INTO `prices` (`base_price`, `start_date`, `end_date`, `product_id`, `priority`, `price`, `curr`, `brands_id`)
    VALUES(1, '2020-06-15 16.00.00', '2020-12-31 23.59.59', 35455, 1, 38.95, 'EUR', 1);
INSERT INTO `prices` (`base_price`, `start_date`, `end_date`, `product_id`, `priority`, `price`, `curr`, `brands_id`)
    VALUES(1, '2020-06-20 00.00.00', '2020-06-21 23.59.59', 35455, 0, 20.50, 'EUR', 1);
INSERT INTO `prices` (`base_price`, `start_date`, `end_date`, `product_id`, `priority`, `price`, `curr`, `brands_id`)
    VALUES(1, '2020-06-15 00.00.00', '2020-06-21 10.00.00', 10, 3, 20.99, 'EUR', 2);
INSERT INTO `prices` (`base_price`, `start_date`, `end_date`, `product_id`, `priority`, `price`, `curr`, `brands_id`)
    VALUES(1, '2020-06-14 15.00.00', '2020-06-18 15.00.00', 10, 0, 30.50, 'EUR', 2);
INSERT INTO `prices` (`base_price`, `start_date`, `end_date`, `product_id`, `priority`, `price`, `curr`, `brands_id`)
    VALUES(1, '2020-06-10 00.00.00', '2020-06-21 10.00.00', 10, 0, 25.44, 'EUR', 2);