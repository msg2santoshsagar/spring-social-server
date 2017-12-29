CREATE TABLE `app_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userid_UNIQUE` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



CREATE TABLE `app_user_role` (
  `app_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `app_user_role` varchar(45) NOT NULL,
  KEY `fk_app_user_role_role_idx` (`app_user_id`),
  KEY `fk_app_user_role_role_idx1` (`app_user_role`),
  CONSTRAINT `fk_app_user_role_user` FOREIGN KEY (`app_user_id`) REFERENCES `app_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_app_user_role_role` FOREIGN KEY (`app_user_role`) REFERENCES `role` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `role` (
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ROLE_APP_USER
ROLE_FB_USER
ROLE_GOOGLE_USER
ROLE_LINKEDIN_USER
ROLE_SOCIAL_USER
ROLE_TWITTER_USER