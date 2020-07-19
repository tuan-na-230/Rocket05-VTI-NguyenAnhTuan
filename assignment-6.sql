-- 1)Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó
USE classicmodels;
DELIMITER $$
CREATE PROCEDURE find_account_in_department (IN DepartmentName VARCHAR(50))
BEGIN
	SELECT * 
    FROM `Account` a
    INNER JOIN Department d
    ON a.DepartmentID = d.DepartmentID
    WHERE d.DepartmentName = DepartmentName;
END $$ 
DELIMITER ;

CALL find_account_in_department ('Bán hàng');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group

DELIMITER $$
CREATE PROCEDURE menber_in_group ()
BEGIN
	SELECT g.GroupName, count(*) AS `member` 
	FROM `group` g
	INNER JOIN groupaccount ga
	ON g.GroupID = ga.GroupID
	GROUP BY g.GroupID;
END $$
DELIMITER ;

CALL menber_in_group();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại
DELIMITER $$
CREATE PROCEDURE count_question_born_in_this_month ()
BEGIN
	SELECT tq.TypeID, tq.TypeName, count(*) AS `number`
	FROM question q
	INNER JOIN typequestion tq
	ON q.TypeID = tq.TypeID
	WHERE month(CreateDate) = month(now())
	GROUP BY tq.TypeID;
END $$
DELIMITER ;

CALL count_question_born_in_this_month();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DELIMITER $$
CREATE PROCEDURE max_typeQuestion () 
BEGIN
	SELECT tq.TypeID
	FROM question q
	INNER JOIN typequestion tq
	ON q.TypeID = tq.TypeID
	GROUP BY tq.TypeID
	HAVING count(*) =
		(SELECT max(table_count.`number`)
		FROM
			(SELECT tq.TypeID, tq.TypeName, count(*) AS `number`
			FROM question q
			INNER JOIN typequestion tq
			ON q.TypeID = tq.TypeID
			GROUP BY tq.TypeID) AS table_count);
END $$ 
DELIMITER ;
-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của
-- người dùng nhập vào
DROP PROCEDURE find_by_string;
DELIMITER $$
CREATE PROCEDURE find_by_string (
	IN group_or_userName_string VARCHAR(50),
    IN switch TINYINT) -- 1 or 0 same grouptable of usertable
BEGIN
	DECLARE temp VARCHAR(50);
    SET temp = '%' + group_or_userName_string + '%';
    
	IF switch = 0 THEN
		SELECT * 
		FROM `group` g
		WHERE g.GroupName LIKE @temp;
	ELSE 	
		SELECT * 
		FROM `customers` c
		WHERE c.customerName LIKE @temp;
	END IF;
END $$ 
DELIMITER ;

CALL find_by_string('a',1);

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
SELECT lengthOfContent
FROM(
	SELECT *, length(q.Content) AS `lengthOfContent`
	FROM typequestion tq
	INNER JOIN question q
	ON tq.TypeID = q.TypeID
	WHERE tq.TypeName = 'Essay'
    ) AS `table_length`;

SELECT * 
FROM 
    (SELECT *, length(q.Content) AS `lengthOfContent`
	FROM typequestion tq
	INNER JOIN question q
	ON tq.TypeID = q.TypeID
	WHERE tq.TypeName = 'Essay') AS table_length;

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DELIMITER $$
CREATE PROCEDURE del_exam_by_id (
	IN ExamID INT)
BEGIN
	DELETE
    FROM exam e
    WHERE e.ExamID = ExamID ;
END $$
DELIMITER ;
-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa), sau đó in số lượng record đã remove từ các table liên quan
-- trong khi removing
    
-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được chuyển về phòng
-- ban default là phòng ban chờ việc

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm
-- nay
DELIMITER $$ 
CREATE PROCEDURE count_question_in_month_begin_1()
BEGIN
	DECLARE beginMonth INT;
    DECLARE endMonth INT;
    SET beginMonth =  1;
    SET endMonth = month(now());
    
    month_loop: LOOP
		IF beginMonth > endMonth THEN
			LEAVE month_loop;
		ELSE
			SELECT beginMonth, 
				CASE
					WHEN count(*) = 0 THEN 'không có câu hỏi nào trong tháng'
					WHEN count(*) THEN count(*)
				END AS number
			FROM question q
            WHERE month(q.CreateDate) = beginMonth;
            
            SET beginMonth = beginMonth + 1;
		END IF;
    END LOOP month_loop;
    
END $$ 
DELIMITER ;

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
-- tháng gần đây nhất (nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào
-- trong tháng")
DELIMITER $$ 
CREATE PROCEDURE count_question_in_month()
BEGIN
	DECLARE beginMonth INT;
    DECLARE endMonth INT;
    SET beginMonth =  month(now()) - 6;
    SET endMonth = month(now());
    
    month_loop: LOOP
		IF beginMonth > endMonth THEN
			LEAVE month_loop;
		ELSE
			SELECT beginMonth, 
				CASE
					WHEN count(*) = 0 THEN 'không có câu hỏi nào trong tháng'
					WHEN count(*) THEN count(*)
				END AS number
			FROM question q
            WHERE month(q.CreateDate) = beginMonth;
            
            SET beginMonth = beginMonth + 1;
		END IF;
    END LOOP month_loop;
    
END $$ 
DELIMITER ;



    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    