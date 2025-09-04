CREATE DATABASE  IF NOT EXISTS `lms_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lms_db`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lms_db
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
-- Password for vrinda-m is: 12345 
INSERT INTO `admin` VALUES (1,'Vrinda Modi','vrinda-m','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `author` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `language` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `isbn` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `publisher` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'The Great Gatsby','F. Scott Fitzgerald','English','61120079','Scribner'),(2,'To Kill a Mockingbird','Harper Lee','English','451524931','JB Lippincott Company'),(3,'1984','George Orwell','English','0743273567','Secker & Warburg'),(4,'Pride and Prejudice','Jane Austen','English','788640149','Penguin Classics'),(5,'The Catcher in the Rye','J.D. Salinger','English','618676542','Little, Brown and Company'),(6,'The Alchemist','Paulo Coelho','English','0062315005','HarperCollins Publishers'),(7,'Brave New World','Aldous Huxley','English','60850522','Chatto & Windus'),(8,'Animal Farm','George Orwell','English','0451526341','Secker & Warburg'),(9,'War and Peace','Leo Tolstoy','Russian','0140447938','Penguin Classics'),(10,'The Hobbit','J.R.R. Tolkien','English','0547928221','George Allen & Unwin'),(11,'Crime and Punishment','Fyodor Dostoevsky','Russian','0486415872','The Russian Messenger'),(12,'The Brothers Karamazov','Fyodor Dostoevsky','Russian','0374528373','The Russian Messenger'),(13,'Les Misérables','Victor Hugo','French','0451419432','A. Lacroix, Verboeckhoven & Cie'),(14,'The Kite Runner','Khaled Hosseini','English','1594631931','Riverhead Books'),(15,'Catch-22','Joseph Heller','English','0684833390','Simon & Schuster'),(16,'Jane Eyre','Charlotte Brontë','English','0141441141','Smith, Elder & Co.'),(17,'Wuthering Heights','Emily Brontë','English','0141439555','Thomas Cautley Newby'),(18,'The Odyssey','Homer','Greek','0140268861','Penguin Classics'),(19,'Moby Dick','Herman Melville','English','1503280781','Harper & Brothers'),(20,'Great Expectations','Charles Dickens','English','0141439560','Chapman & Hall'),(21,'Dracula','Bram Stoker','English','0486411095','Archibald Constable and Company'),(22,'Frankenstein','Mary Shelley','English','0486282112','Lackington, Hughes, Harding, Mavor & Jones'),(23,'The Iliad','Homer','Greek','0140445927','Penguin Classics'),(24,'Don Quixote','Miguel de Cervantes','Spanish','0060934344','Francisco de Robles'),(25,'The Divine Comedy','Dante Alighieri','Italian','0140448950','Penguin Classics'),(26,'Hamlet','William Shakespeare','English','0743477127','Simon & Schuster'),(27,'Macbeth','William Shakespeare','English','0743477103','Simon & Schuster'),(28,'A Tale of Two Cities','Charles Dickens','English','0486406512','Chapman & Hall'),(29,'The Scarlet Letter','Nathaniel Hawthorne','English','0486280489','Ticknor, Reed & Fields'),(30,'Heart of Darkness','Joseph Conrad','English','0486264645','Blackwood Magazine');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue_books`
--

DROP TABLE IF EXISTS `issue_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issue_books` (
  `issue_id` int NOT NULL AUTO_INCREMENT,
  `book_id` int NOT NULL,
  `student_id` int NOT NULL,
  `issue_date` date NOT NULL,
  `due_date` date NOT NULL,
  `status` varchar(20) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'pending',
  PRIMARY KEY (`issue_id`),
  UNIQUE KEY `book_id` (`book_id`,`student_id`,`status`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue_books`
--

LOCK TABLES `issue_books` WRITE;
/*!40000 ALTER TABLE `issue_books` DISABLE KEYS */;
INSERT INTO `issue_books` VALUES (1,5,3,'2024-10-01','2024-10-15','returned'),(2,10,1,'2024-10-10','2024-10-20','pending'),(3,2,4,'2024-10-05','2024-10-25','returned'),(4,7,8,'2024-10-15','2024-10-29','pending'),(5,1,10,'2024-10-18','2024-10-31','pending'),(6,12,6,'2024-09-25','2024-10-05','returned'),(7,9,7,'2024-10-02','2024-10-16','returned'),(8,4,5,'2024-10-12','2024-10-22','pending'),(9,3,11,'2024-10-01','2024-10-14','overdue'),(10,6,13,'2024-10-04','2024-10-18','returned'),(11,8,15,'2024-10-10','2024-10-20','pending'),(12,11,9,'2024-10-15','2024-10-25','pending'),(13,13,12,'2024-10-17','2024-10-31','pending'),(14,19,14,'2024-10-19','2024-11-02','returned'),(15,14,2,'2024-10-20','2024-11-05','pending'),(16,17,16,'2024-10-05','2024-10-19','returned'),(17,15,19,'2024-10-12','2024-10-26','pending'),(18,20,17,'2024-10-07','2024-10-21','overdue'),(19,18,18,'2024-10-15','2024-10-29','returned'),(20,16,20,'2024-10-11','2024-10-25','pending'),(21,12,21,'2024-10-01','2024-10-15','returned'),(22,15,22,'2024-10-05','2024-10-20','pending'),(23,9,23,'2024-10-10','2024-10-24','returned'),(24,4,24,'2024-10-15','2024-10-30','pending'),(25,14,25,'2024-10-20','2024-11-04','returned'),(26,7,26,'2024-10-25','2024-11-10','pending'),(27,20,27,'2024-10-12','2024-10-26','overdue'),(28,5,28,'2024-10-18','2024-11-01','returned'),(29,3,29,'2024-10-08','2024-10-22','pending'),(30,18,30,'2024-10-13','2024-10-27','returned'),(31,6,31,'2024-10-19','2024-11-02','overdue'),(32,1,32,'2024-10-21','2024-11-05','pending'),(33,8,33,'2024-10-23','2024-11-06','returned'),(34,10,34,'2024-10-11','2024-10-25','pending'),(35,19,35,'2024-10-17','2024-10-31','overdue'),(36,2,2,'2024-11-01','2024-11-08','pending'),(37,2,4,'2024-11-23','2024-11-30','pending'),(38,1,2,'2024-11-23','2024-11-30','pending'),(39,4,6,'2024-11-23','2024-11-30','pending'),(40,7,9,'2024-11-23','2024-11-30','pending'),(41,5,18,'2024-11-23','2024-11-30','pending'),(42,2,5,'2025-03-06','2025-03-13','returned'),(43,2,3,'2025-03-02','2025-03-09','pending'),(44,1,6,'2025-03-05','2025-03-12','pending');
/*!40000 ALTER TABLE `issue_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librarians`
--

DROP TABLE IF EXISTS `librarians`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `librarians` (
  `lib_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `address` text COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`lib_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librarians`
--

LOCK TABLES `librarians` WRITE;
/*!40000 ALTER TABLE `librarians` DISABLE KEYS */;
-- Password for mila-k is: password
-- Passowrd for alex-a is: testPassword
INSERT INTO `librarians` VALUES (1,'Mila Kunis','mila-k','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8','0123456789','Mahananda Para'),(3,'Alex','alex-a','fd5cb51bafd60f6fdbedde6e62c473da6f247db271633e15919bab78a02ee9eb','01155997733','Darjeeling More');
/*!40000 ALTER TABLE `librarians` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `course` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `address` text COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Kevin Shah','kevin-s','kevin@gmail.com','0123456789','BTech','Mahananda Para'),(2,'Kaley Cuoco','kaley-c','kaley@gmail.com','9876543210','BA','Sevoke Road'),(3,'Emma Watson','emma-w','emma@gmail.com','1122334455','BSc','Oxford Street'),(4,'Scarlett Johansson','scarjo','scar@gmail.com','5566778899','MA','Park Avenue'),(5,'Natalie Portman','nat-p','natp@gmail.com','6677889900','BFA','Hollywood Boulevard'),(6,'Chris Evans','chris-e','cevans@gmail.com','9988776655','BCom','Main Street'),(7,'Robert Downey','robert-d','rdjr@gmail.com','8877665544','BBA','Sunset Boulevard'),(8,'Jennifer Lawrence','jlaw','jlaw@gmail.com','7766554433','MSc','Highland Avenue'),(9,'Tom Holland','tom-h','tholland@gmail.com','6655443322','BCA','Broadway'),(10,'Zendaya Maree','zendaya','zendaya@gmail.com','5544332211','MBA','Elm Street'),(11,'Chris Hemsworth','chris-h','chems@gmail.com','4433221100','MTech','Harbour Road'),(12,'Gal Gadot','gal-g','gal@gmail.com','9988007766','BArch','Queens Street'),(13,'Henry Cavill','henry-c','hcavill@gmail.com','8877006655','LLB','Lexington Avenue'),(14,'Margot Robbie','margot-r','margot@gmail.com','7766005544','BPharma','Melbourne Street'),(15,'Dwayne Johnson','dwayne-j','dwayne@gmail.com','6655004433','BEd','Rock Street'),(16,'Ryan Reynolds','ryan-r','ryan@gmail.com','5544003322','BE','Maple Avenue'),(17,'Emma Stone','emma-s','estone@gmail.com','4433002211','BSc','Willow Lane'),(18,'Jason Momoa','jason-m','jason@gmail.com','3322110099','MCA','Ocean Drive'),(19,'Anne Hathaway','anne-h','anne@gmail.com','2211009988','PhD','Emerald Road'),(20,'Hugh Jackman','hugh-j','hugh@gmail.com','1100998877','MBBS','Wolf Street'),(21,'Tom Cruise','tom-c','tomc@gmail.com','1234567890','BBA','Mission Road'),(22,'Sandra Bullock','sandra-b','sandra@gmail.com','2345678901','MBA','Sunrise Avenue'),(23,'Leonardo DiCaprio','leo-d','leo@gmail.com','3456789012','BCom','Ocean Drive'),(24,'Angelina Jolie','angie-j','angie@gmail.com','4567890123','BA','Willow Street'),(25,'Brad Pitt','brad-p','bradp@gmail.com','5678901234','MA','Maple Avenue'),(26,'Mila Kunis','mila-k','mila@gmail.com','6789012345','BTech','Aspen Lane'),(27,'Ashton Kutcher','ashton-k','ashton@gmail.com','7890123456','BSc','Elm Street'),(28,'Johnny Depp','johnny-d','johnny@gmail.com','8901234567','LLB','Pirate Bay'),(29,'Helena Bonham','helena-b','helena@gmail.com','9012345678','BPharma','Carter Road'),(30,'Keanu Reeves','keanu-r','keanu@gmail.com','0123456798','MTech','Neo Avenue'),(31,'Charlize Theron','charlize-t','charlize@gmail.com','1098765432','MBBS','Atomic Lane'),(32,'Matt Damon','matt-d','mattd@gmail.com','2198765430','BE','Bourne Street'),(33,'Anne Curtis','anne-c','annec@gmail.com','3298765431','PhD','Emerald Lane'),(34,'Halle Berry','halle-b','halle@gmail.com','4398765429','MCA','Sunset Boulevard'),(35,'Ryan Gosling','ryan-g','ryang@gmail.com','5498765412','BArch','Drive Avenue');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'lms_db'
--

--
-- Dumping routines for database 'lms_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-18 20:56:45
