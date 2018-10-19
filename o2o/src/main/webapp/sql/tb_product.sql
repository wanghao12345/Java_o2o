CREATE TABLE `tb_product`(
  `product_id` int(100) NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(100) NOT NULL,
  `product_desc` VARCHAR(2000) DEFAULT NULL,
  `img_addr` VARCHAR(2000) DEFAULT '',
  `normal_price` VARCHAR(100) DEFAULT NULL,
  `promotion_price` VARCHAR(100) DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT '0',
  `product_category_id` int(11) DEFAULT NULL,
  `shop_id` int(20) NOT NULL DEFAULT '0',
	primary key(`product_id`),
	CONSTRAINT `fk_product_procate` foreign KEY (`product_category_id`) REFERENCES `tb_product_category`(`product_category_id`),
	CONSTRAINT `fk_product_shop` foreign KEY (`shop_id`) REFERENCES `tb_shop`(`shop_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;