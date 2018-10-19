CREATE TABLE `tb_product_category`(
  `product_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_category_name` VARCHAR(100) NOT NULL,
  `priority` int(2) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
	`shop_id` int(20) NOT NULL DEFAULT '0',
	primary key(`product_category_id`),
	CONSTRAINT `fk_procate_shop` foreign KEY (`shop_id`) REFERENCES `tb_shop`(`shop_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;