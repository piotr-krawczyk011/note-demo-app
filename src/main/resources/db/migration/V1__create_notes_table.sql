USE `note_demo_app`;

DROP TABLE IF EXISTS `notes`;

CREATE TABLE `notes` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `title` varchar(45) NOT NULL ,
                            `content` text DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


