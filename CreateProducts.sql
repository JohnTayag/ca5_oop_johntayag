-- OOP 2022

DROP DATABASE IF EXISTS `products_database`;
CREATE DATABASE `products_database`;
USE `products_database`;
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `PRICE` DECIMAL(10,2) NOT NULL,
  `PRODUCT_SIZE` DECIMAL(10,1) NOT NULL,
  PRIMARY KEY  (`PRODUCT_ID`)
  );

INSERT INTO product VALUES

                   (null, "Asos Design Relaxed Fit",  55.50, 8.5),
                    (null,"Adidas Striped Shirt",  20.99, 9),
                      (null, "Polo Ralph Lauren icon logo long sleeve poplin shirt in blue",  100.50, 7),
                     (null,  "Levi's slouchy revere collar shirt in abrstact print",  66, 10),
                   (null,  "MIX & MATCH COLLUSION Unisex boxy shirt co-ord in warped print",  80.50, 6.5),
                     (null,  "Puma crew tshirt",30, 7.5),
                    (null,  "Jack & Jones Originals short sleeve revere collar shirt in pink mini animal print",  40.50, 8.5),
                    (null, "Pull&Bear shirt",  33.50, 7.5),
                   (null, "Tommy Jeans slim fit oxford shirt in white", 66.20, 5),
                     (null, "Adidas oversized shirt",  70.80, 8);
