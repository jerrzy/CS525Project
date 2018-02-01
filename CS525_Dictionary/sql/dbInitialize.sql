CREATE TABLE `artical` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL , 
  `title` varchar(100) NOT NULL,  
  `content` varchar(500) NOT NULL,  
  PRIMARY KEY (`id`),
  KEY `user_id`(user_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;