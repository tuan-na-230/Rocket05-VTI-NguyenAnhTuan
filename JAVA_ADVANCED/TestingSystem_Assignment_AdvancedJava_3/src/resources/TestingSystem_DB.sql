-- =============================================
-- Create Structure database
-- =============================================

-- Drop the database if it already exists
DROP DATABASE IF EXISTS TestingSystem;
-- Create database
CREATE DATABASE IF NOT EXISTS TestingSystem;
USE TestingSystem;

-- Create table user
DROP TABLE IF EXISTS 	`User`;
CREATE TABLE IF NOT EXISTS `User` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`username`	 	CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`username`) >= 6 AND LENGTH(`username`) <= 50),
	`password` 		VARCHAR(50) NOT NULL,
	`firstName` 	NVARCHAR(50) NOT NULL,
	`lastName` 		NVARCHAR(50) NOT NULL,
	`role` 			ENUM('Admin','Employee','Manager') NOT NULL DEFAULT 'Employee'
);

-- Create table Group
DROP TABLE IF EXISTS 	`Group`;
CREATE TABLE IF NOT EXISTS `Group` (
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name` 			NVARCHAR(50) NOT NULL UNIQUE,
	create_time		DATETIME NOT NULL DEFAULT NOW()
);

-- =============================================
-- INSERT DATA 
-- =============================================
USE TestingSystem;
update `User` set firstName = 'abc', lastName = 'abc' where username = 'thanhhung12';
INSERT INTO `User` (`username`,			`password`,			`firstName`,	`lastName`,	 `role` )
VALUE			('hanh.havan',			'123456',		'Ha',			'Van Hanh',			'MANAGER'	), 
				('thanhhung12',			'123456',		'Nguyen ',		'Thanh Hung',		'MANAGER'	), 
				('can.tuananh',			'123456',		'Can',			'Tuan Anh',			'MANAGER'	), 
				('toananh123',			'123456',		'Nguyen',		'Anh Toan',			'MANAGER'	), 
				('duynn03',				'123456',		'Nguyen',		'Duy',				'MANAGER'	), 
				('manhhung123',			'123456',		'Nguyen',		'Manh Hung',		'MANAGER'	),
 				('maianhvti123',		'123456',		'Nguyen',		'Mai Anh',			'EMPLOYEE'	),
				('tuanvti12344',		'123456',		'Nguyen',		'Van Tuan',			'EMPLOYEE'	),
				('ngthuy123',			'123456',		'Nguyen',		'Thi Thuy',			'EMPLOYEE'	),
				('quanganhvti',			'123456',		'Nguyen',		'Quang Anh',		'MANAGER'	),
				('hoanghungvti',	   	'123456',		'Vu',			'Hoang Hung',		'EMPLOYEE'	),
				('quocanhvti',			'123456',		'Nguyen',		'Quoc Anh',			'ADMIN'		),
				('vananhvti',			'123456',		'Nguyen',		'Van Anh',			'EMPLOYEE'	),
				('mailanvti',			'123456',		'Nguyen',		'Ngoc Bao Lan',		'MANAGER'	),
				('tuanhungvti',			'123456',		'Vu',			'Tuan Hung',		'EMPLOYEE'	),
				('xuanmaivti',			'123456',		'Nguyễn',		'Xuân Mai',			'EMPLOYEE'	);
				
INSERT INTO `Group` 	(`name` ,		create_time)
VALUE				('Java Fresher',	'2020-03-03'),			
					('Java Web',		'2020-03-03'),			
					('C# Fresher',		'2020-03-03');
                    
SELECT 	`id`, `username`,			`password`,			CONCAT(`firstName`,	`lastName`) AS fullName,	 `role`
FROM 	`User`
