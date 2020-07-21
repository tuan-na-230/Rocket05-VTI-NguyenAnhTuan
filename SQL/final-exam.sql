CREATE DATABASE Final_Database;
USE Final_Database;

DROP TABLE Student;
CREATE TABLE Student 
(
	RN 		INT 			NOT NULL AUTO_INCREMENT,
    `Name`	VARCHAR(50) 	NOT NULL,
    Age 	INT,
    Gender	TINYINT,
    
    PRIMARY KEY (RN)
);

CREATE TABLE `Subject` 
(
	sID		INT 			NOT NULL AUTO_INCREMENT,
    sName 	VARCHAR(50) 	NOT NULL,
    
    PRIMARY KEY (sID)
);

DROP TABLE StudentSubject;
CREATE TABLE StudentSubject 
(
	RN 		INT 			NOT NULL,
    sID 	INT 			NOT NULL,
    MARK	TINYINT 		NOT NULL,
    DATE 	DATETIME 		NOT NULL,
    
    PRIMARY KEY(RN,sID),
    FOREIGN KEY (RN) REFERENCES Student (RN) ON DELETE CASCADE,
    FOREIGN KEY (sID) REFERENCES `Subject` (sID) ON DELETE CASCADE
);

INSERT INTO Student (RN, Name, Age, Gender)
VALUES	(1, 'Nguyen Anh Tuan', 21, '0'),
		(2, 'Nguyen Quang Anh', 18, '0'),
		(3, 'Nguyen Trung Nhat', 22, '0'),
        (4, 'Tran The Gia', 19, '0'),
        (5, 'Nguyen Trung Kien', 20, '0'),
        (6, 'Mai Thi Tuyet', 20, '1'),
        (7, 'Nguyen Thi Mai Loai', 19, '1'),
        (8, 'Nguyen Thi Kim Ngan', 18, '1');
        
INSERT INTO 
	Subject (sID	, sName)
VALUES 	
			(	1	, 'He dieu hanh'),
			(	2	, 'Kien truc may tinh'),
			(	3	, 'Phan tich thiet ke thuat toan'),
			(	4	, 'Cau truc du lieu va giai thuat'),
			(	5	, 'Xu ly tin hieu'),
			(	6	, 'Lap trinh ung dung'),
			(	7	, 'Lap trinh huong doi tuong'),
			(	8	, 'Nguyen ly ngon ngu lap trinh');
        
INSERT INTO 
	StudentSubject 	( RN	,  sID	, 	Mark  ,       `Date`	 	)
VALUES 
					(	1	, 	1	, 	 10   , '2020-02-02 19:02:03'),
                    (	2	, 	1	, 	 8    , '2020-02-02 19:02:13'),
                    (	3	, 	1	, 	 9    , '2020-02-02 19:02:23'),
                    (	4	, 	1	, 	 7    , '2020-02-02 19:02:33'),
                    (	5	, 	1	, 	 10   , '2020-02-02 19:02:43'),
                    (	6	, 	1	, 	 8    , '2020-02-02 19:02:53'),
                    (	7	, 	1	, 	 9    , '2020-02-02 19:03:13'),
                    (	8	, 	1	, 	 10   , '2020-02-02 19:03:23'),
                    (	1	, 	2	, 	 7    , '2020-04-02 19:02:33'),
                    (	2	, 	2	, 	 8    , '2020-04-02 19:02:53'),
                    (	3	, 	2	, 	 9    , '2020-04-02 19:02:43'),
                    (	4	, 	2	, 	 8    , '2020-04-02 19:02:13'),
                    (	5	, 	2	, 	 7    , '2020-04-02 19:02:23'),
                    (	6	, 	2	, 	 9    , '2020-04-02 19:02:33'),
                    (	7	, 	2	, 	 9    , '2020-04-02 19:02:43'),
                    (	8	, 	2	, 	 7    , '2020-04-02 19:02:53'),
                    (	1	, 	3	, 	 10   , '2020-06-02 19:03:03');
-- b) Viết lệnh để
		-- a. Lấy tất cả các môn học không có bất kì điểm nào
SELECT s.sID, s.sName 
FROM `Subject` s
LEFT JOIN StudentSubject ss
ON s.sID = ss.sID
GROUP BY s.sName
HAVING count(ss.Mark) = 0;

		-- b. Lấy danh sách các môn học có ít nhất 2 điểm
SELECT s.sID, s.sName 
FROM `Subject` s
LEFT JOIN StudentSubject ss
ON s.sID = ss.sID
GROUP BY s.sName
HAVING count(ss.Mark) >= 2;

-- c) Tạo "StudentInfo" view có các thông tin về học sinh bao gồm:
-- RN,sID,Name, Age, Gender, sName, Mark, Date. Với cột Gender show
-- Male để thay thế cho 0, Female thay thế cho 1 và Unknow thay thế cho
-- null.
DROP VIEW StudentInfo;
CREATE VIEW StudentInfo AS
	SELECT 
		s.RN, 
		ss.sID, 
        s.`Name`, 
        s.Age, 
        CASE 
			WHEN s.Gender = 0 THEN 'Male'
            WHEN s.Gender = 1 THEN 'Female'
            WHEN s.Gender IS NULL THEN 'Unknow'
		END AS Gender,
        su.sName,
        ss.Mark, 
        ss.`Date`
    FROM Student s
		LEFT JOIN StudentSubject ss
		ON s.RN = ss.RN
        INNER JOIN `Subject` su
        ON ss.sID = su.sID; 

-- d) Tạo trigger cho table Subject:
		-- a. Trigger CasUpdate: khi thay đổi data của cột sID, thì giá trị của
		-- cột sID của table StudentSubject cũng thay đổi theo
DELIMITER $$
CREATE TRIGGER after_subject_update
AFTER UPDATE ON Subject
FOR EACH ROW 
BEGIN
	IF OLD.sID <> NEW.sID THEN
		UPDATE StudentSubject
		SET StudentSubject.sID = NEW.sID
		WHERE StudentSubject.sID = OLD.sID;
	END IF;
END $$
DELIMITER ;
    
        -- b Trigger casDel: Khi xóa 1 student, các dữ liệu của table
		-- StudentSubject cũng sẽ bị xóa theo
DELIMITER $$
CREATE TRIGGER after_student_del
AFTER DELETE ON student
FOR EACH ROW 
BEGIN
	DELETE StudentSubject
    FROM StudentSubject
    WHERE StudentSubject.RN = OLD.RN;
END $$
DELIMITER ;
        
-- e) Viết 1 thủ tục (có 2 parameters: student name, mark). Thủ tục sẽ xóa tất cả
-- các thông tin liên quan tới học sinh có cùng tên như parameter và tất cả
-- các điểm nhỏ hơn của các học sinh đó.
-- Trong trường hợp nhập vào "*" thì thủ tục sẽ xóa tất cả các học sinh
DROP PROCEDURE p_del_by_name_and_mark;
DELIMITER $$
CREATE PROCEDURE p_del_by_name_and_mark (
	IN student_name VARCHAR(50), 
    IN mark INT)
BEGIN
	-- delete all record 
	IF mark = '*' THEN
		TRUNCATE TABLE StudentSubject; 
	-- delete all record when condition = true
	ELSE 
        DELETE ss 
        FROM StudentSubject ss
        INNER JOIN Student s
        ON ss.RN = s.RN
        WHERE ss.Mark < mark AND s.Name = student_name;
	END IF;
END $$
DELIMITER ;