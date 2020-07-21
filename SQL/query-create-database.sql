CREATE DATABASE QLBT;
USE QLBT;

CREATE TABLE Department (
	DepartmentID 	INT NOT NULL AUTO_INCREMENT,
    DepartmentName 	VARCHAR(100) NOT NULL,
    
    PRIMARY KEY (DepartmentID)
);

CREATE TABLE `Position` (
	PositionID 		INT NOT NULL AUTO_INCREMENT,
    PositionName 	VARCHAR(100) NOT NULL,
    
    PRIMARY KEY (PositionID)
);

CREATE TABLE `Account`(
	AccountID 		INT AUTO_INCREMENT,
    Email 			VARCHAR(100) NOT NULL,
    Username 		VARCHAR(50) NOT NULL,
    FullName 		VARCHAR(50) NOT NULL,
    DepartmentID 	INT NOT NULL,
    PositionID 		INT NOT NULL,
    CreateDate 		date NOT NULL,
    
    PRIMARY KEY (AccountID),
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID),
    FOREIGN KEY (PositionID) REFERENCES Position (PositionID)
);
DROP TABLE `Group`;
CREATE TABLE `Group` (
	GroupID 		INT NOT NULL,
    GroupName 		VARCHAR(50) NOT NULL,
    CreatorID 		int NOT NULL,
    CreateDate 		date NOT NULL,
    
    PRIMARY KEY (GroupID),
    FOREIGN KEY (CreatorID) REFERENCES account (AccountID)
);

CREATE TABLE GroupAccount (
	GroupID 		INT NOT NULL,
    AccountID 		INT NOT NULL,
    JoinDate 		date NOT NULL,
    
    FOREIGN KEY (GroupID) REFERENCES `Group` (GroupID),
    FOREIGN KEY (AccountID) REFERENCES `Account` (AccountID)
);

CREATE TABLE TypeQuestion (
	TypeID 			INT NOT NULL AUTO_INCREMENT,
    TypeName 		VARCHAR(50) NOT NULL,
    
    PRIMARY KEY (TypeID)
);

CREATE TABLE CategoryQuestion (
	categoryID 		INT NOT NULL AUTO_INCREMENT,
    CategoryName 	VARCHAR(50) NOT NULL,
    
    PRIMARY KEY (categoryID)
);

CREATE TABLE Question (
	QuestionID 		INT NOT NULL AUTO_INCREMENT,
    Content 		VARCHAR(50) NOT NULL,
    CategoryID 		INT NOT NULL,
    TypeID 			INT NOT NULL,
    CreatorID 		INT NOT NULL,
    CreateDate 		DATE NOT NULL,
    
    PRIMARY KEY (QuestionID),
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion (TypeID),
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID)
);

CREATE TABLE Answer (
	AnswerID 		INT NOT NULL AUTO_INCREMENT,
    Content 		VARCHAR(50) NOT NULL,
    QuestionID 		INT NOT NULL,
    isCorrect 		INT NOT NULL,
    
    PRIMARY KEY (AnswerID),
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

CREATE TABLE Exam (
	ExamID 			INT NOT NULL AUTO_INCREMENT,
    `Code` 			VARCHAR(10) NOT NULL,
    Title 			VARCHAR(50) NOT NULL,
    CategoryID 		INT NOT NULL,
    Duration 		datetime NOT NULL,
    CreatorID 		INT NOT NULL,
    CreateDate 		date NOT NULL,
    
    PRIMARY KEY (ExamID),
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    FOREIGN KEY (CreatorID) REFERENCES Account (AccountID)
);

CREATE TABLE ExamQuestion (
	ExamID 			INT NOT NULL,
    questionID 		INT NOT NULL,
    
    FOREIGN KEY (ExamID) REFERENCES Exam (ExamID),
	FOREIGN KEY (questionID) REFERENCES Question (questionID)
);

    