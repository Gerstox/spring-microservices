CREATE DATABASE `client_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- client_db.people definition

CREATE TABLE `people` (
  `age` int DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `identification` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `gender` enum('FEMALE','MALE') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- client_db.clients definition

CREATE TABLE `clients` (
  `status` tinyint(1) DEFAULT '1',
  `id` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKkujwxi9ys82vxhwt5m6u4ico8` FOREIGN KEY (`id`) REFERENCES `people` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE DATABASE `management_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- management_db.accounts definition

CREATE TABLE `accounts` (
  `initial_balance` decimal(10,2) DEFAULT '0.00',
  `status` bit(1) DEFAULT b'1',
  `account_number` varchar(255) NOT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `account_type` varchar(25) DEFAULT 'AHORROS',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6kplolsdtr3slnvx97xsy2kc8` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- management_db.movements definition

CREATE TABLE `movements` (
  `balance` double NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `value` double NOT NULL,
  `date` datetime NOT NULL,
  `account_id` varchar(255) NOT NULL,
  `movement_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1a6nru7corjv5b2vidld4ef5r` (`account_id`),
  CONSTRAINT `FK1a6nru7corjv5b2vidld4ef5r` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;