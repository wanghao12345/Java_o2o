CREATE TABLE `tb_product_img`(
  `product_img_id` int(20) NOT NULL AUTO_INCREMENT,
  `img_addr` VARCHAR(2000) NOT NULL,
  `img_desc` VARCHAR(2000) DEFAULT NULL,
  `priority` int(2) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
	`product_id` int(20) DEFAULT NULL,
	primary key(`product_img_id`),
	CONSTRAINT `fk_proimg_product` foreign KEY (`product_id`) REFERENCES `tb_product`(`product_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;