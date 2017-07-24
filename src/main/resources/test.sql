#insert into users(login, password) values('Strix', '4359848791');
#select * from users;
#update users set login ='Taras', password = 'sadas123' where id =1;
#delete from users where id = 4;
#SELECT sticker_name FROM notes WHERE user_id= '7';
#INSERT INTO notes (note, user_id, sticker_name) VALUE ('dasdasdsa', 1 , 'xzXZX');
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `notes`
--

DROP TABLE IF EXISTS `notes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notes` (
  `idnotes` int(11) NOT NULL AUTO_INCREMENT,
  `note` text CHARACTER SET utf8,
  `user_id` int(11) NOT NULL,
  `sticker_name` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`idnotes`),
  KEY `note_users__fk` (`user_id`),
  CONSTRAINT `notes_users__fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notes`
--

LOCK TABLES `notes` WRITE;
/*!40000 ALTER TABLE `notes` DISABLE KEYS */;
INSERT INTO `notes` VALUES (11,'Strix',15,'Info'),(44,NULL,17,'Лялька'),(45,'????????',17,'??????'),(46,'????',17,'??????'),(47,'???? ??? ?!',17,'??????'),(48,NULL,18,'Андрійка'),(49,'???????? ???????',18,'????????'),(50,'???????? ???????',18,'????????'),(51,'івасіва',15,'Info'),(52,'Михасько',15,'Info'),(53,'Олег',15,'Info'),(54,'Коля',15,'Info'),(55,'Оля',15,'Info'),(56,NULL,15,'DONE'),(57,'Звичайно все виконаю )',15,'DONE'),(58,'Я чексно ще незнаю',15,'DONE'),(59,NULL,15,'стрикс'),(60,NULL,15,'Strix'),(61,'авіаіваів',15,'Strix'),(62,'авіаіваів',15,'стрикс'),(63,'fsdfsdfdsf',15,'DONE'),(64,'fdsfsdfsdfds',15,'DONE'),(65,'fdsfdsfsdfsd',15,'DONE'),(66,'fdsfsdfdsfdsf',15,'DONE'),(67,'fsdfsdfsdfds',15,'DONE'),(68,'fsdfsdfdsfdsfdsfdsfsdfdsfdsfsdfds',15,'DONE'),(69,'fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff',15,'DONE'),(70,'xczc',15,'Info'),(71,'О це вже суперок :)',15,'DONE'),(72,'смчсячсяч',15,'DONE'),(73,'сячсячсячся',15,'DONE'),(74,'сссссссссссссссссссссссссссссссссссссссссссссссссссс',15,'DONE'),(75,'ссссссссссссссссссссссссссссссссссссссссссссссссссссссс',15,'DONE'),(76,'сячсссссссссссссссссссссссссссссссссссссссссссссчячс',15,'Info'),(77,'сясячсячс',15,'Info'),(78,'сясясячс',15,'Info'),(79,'счясячсяч',15,'стрикс'),(80,'віфвфівфі',15,'DONE'),(81,'віфвфівфі',15,'DONE'),(82,'вфівфівфівфі',15,'DONE'),(83,'Хелов бейба!',15,'DONE'),(84,'Ну вроді не погано!',15,'стрикс'),(85,'А ви що скажете вам подобається?!',15,'Strix'),(86,'Я хтівби краще )\r\n',15,'Info'),(87,NULL,15,'Якось так'),(88,'11111111111111111111111111111111111111111\r\n',15,'Якось так'),(89,'ссссссссссссссссссссссссссссссссссссссссссссссссссссссс',15,'Якось так');
/*!40000 ALTER TABLE `notes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-24 15:19:14
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) CHARACTER SET utf8 NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 NOT NULL,
  `email` text CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  KEY `users_login_uindex` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (15,'Strix','4359848791','strixik1985@gmail.com'),(16,'Nadya','2259','nadya@mail.ru'),(17,'Іван','123','sdsfsd@mail.ru'),(18,'Андрійко','123','123@mail.ru');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-24 15:19:14

