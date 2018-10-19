CREATE TABLE `tb_wechat_auth`(
  `wechat_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `open_id` VARCHAR(1024) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`wechat_auth_id`),
  CONSTRAINT `fk_wechat_auth_profile` foreign KEY (`user_id`) REFERENCES `tb_person_info`(`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;