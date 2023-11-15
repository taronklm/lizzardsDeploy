CREATE TABLE `song` (
    `userId` int NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(100) DEFAULT NULL,
    `actor` VARCHAR(100) DEFAULT NULL,
    `songDuration` int DEFAULT NULL,
    `likes` int DEFAULT NULL,
    `genre` VARCHAR(100) DEFAULT NULL
)