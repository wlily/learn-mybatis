CREATE TABLE `user`(
  `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userName',
  `user_age` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userAge',
  `user_address` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userAddress',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`user`';

CREATE TABLE `article`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

insert into user values('1', 'summer', '20', 'beijing');
insert into user values('2', 'summer', '18', 'beijing');

insert into `article` VALUES ('1', '1', 'test_title1', 'test_content1');
insert into `article` VALUES ('2', '1', 'test_title2', 'test_content2');
insert into `article` VALUES ('3', '1', 'test_title3', 'test_content3');
insert into `article` VALUES ('4', '1', 'test_title4', 'test_content4');

TRUNCATE table user;
select * from user;
select * from article;