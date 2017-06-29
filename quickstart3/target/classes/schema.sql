create table t_user (
  id int(11) not null AUTO_INCREMENT,
  userName varchar(50) DEFAULT NULL,
  userAge int(11) DEFAULT NULL,
  userAddress varchar(200) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into t_user values('1', 'summer', '20', 'beijing');
insert into t_user values('2', 'spring', '18', 'beijing');
select * from t_user;