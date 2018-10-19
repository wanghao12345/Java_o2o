CREATE TABLE `tb_local_auth`(
  `local_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `username` VARCHAR(128) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  `create_time` datetime DEFAULT NULL,
	`last_edit_time` datetime DEFAULT NULL,
	 PRIMARY KEY (`local_auth_id`),
   UNIQUE KEY `uk_local_profile`(`username`),
   CONSTRAINT `fk_auth_profile` foreign KEY (`user_id`) REFERENCES `tb_person_info`(`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;