DROP DATABASE IF EXISTS posting;

create database posting;

use posting;

CREATE TABLE post (
  id int(16) unsigned NOT NULL AUTO_INCREMENT,
  title varchar(260) DEFAULT NULL,
  content varchar(400) DEFAULT NULL,
  photo mediumblob,
  mime varchar(20) DEFAULT NULL,
  tags varchar(1000) DEFAULT NULL,
  UNIQUE KEY id (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4
