CREATE TABLE `tb_person_info`(
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) DEFAULT NULL,
  `profile_img` VARCHAR(1024) DEFAULT NULL,
  `email` VARCHAR(1024) DEFAULT NULL,
  `gender` VARCHAR(2) DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT '0' COMMENT '0:禁止使用本商城，1:允许使用本商城',
  `user_type` int(2) NOT NULL DEFAULT '1' COMMENT '1:顾客，2:店家，3:超级管理员',
  `create_time` datetime DEFAULT NULL,
	`last_edit_time` datetime DEFAULT NULL,
	primary key(`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;