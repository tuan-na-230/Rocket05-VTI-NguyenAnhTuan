USE qlbt;

INSERT INTO Department (DepartmentName)
VALUES		("Phòng tài nguyên và môi trường"),
			("Phòng nhân sự"),
			("Phòng kiểm toán"),
			("Phòng tài chính"),
			("Phòng bảo vệ"),
			("Phòng an ninh"),
			("Phòng ngoại giao"),
			("Phòng văn hóa"),
			("Phòng tuyên truyền"),
			("Phòng công đoàn");
    
INSERT INTO Position (PositionName)
VALUES
					("Giám đốc"),
					("Phó giám đốc"),
					("Trưởng phòng"),
					("Phó trưởng phòng"),
					("Trưởng phòng kế toán"),
					("Trưởng phòng tài chính"),
					("Trưởng phòng vệ sinh"),
					("Phó phòng vệ sinh"),
					("Nhân viên"),
					("Trường phòng nhân sự");

INSERT INTO Account (Email						, 	Username		,	 FullName				, DepartmentID	, PositionID	, CreateDate)
VALUE	
					("daobanhat991999@gmail.com", 	"daobanhat"		, 	"Nguyen Anh Tuan"		, 1				, 1			, '2020-01-02'),
					("thanh010@gmail.com"		, 	"daobanhat"		, 	"Nguyen Anh Tuan"		, 2				, 2			 ,'2020-02-02'),
					("tungna12@gmail.com"		, 	"nguyen tung"	, 	"Nguyen Anh Tung"		, 3				, 3			, '2020-03-02'),
					("hangnt97@gmail.com"		, 	"Nguyen Hang"	, 	"Nguyen Thi Hang"		, 4				, 4			, '2020-08-02'),
					("hungnv90@gmail.com"		, 	"Nguyen Hung"	, 	"Nguyen Van Hung"		, 5				, 5			, '2019-09-02'),
					("yennt90@gmail.com"		, 	"Nguyen Yen"	, 	"Nguyen Thi Yen"		, 1				, 6			, '2020-10-02'),
					("hinv99@gmail.com"			, 	"Nguyen Hi"		, 	"Nguyen Van Hi"			, 7				, 7			, '2019-04-02'),
					("thamnt99@gmail.com"		, 	"Nguyen Tham"	, 	"Nguyen Thi Tham"		, 8				, 8			, '2020-02-02'),
					("quynhnt00@gmail.com"		, 	"Nguyen Quynh"	, 	"Nguyen Thi Quynh"		, 9				, 1			, '2019-01-02'),
					("ngannt00@gmail.com"		, 	"Nguyen Ngan"	, 	"Nguyen Thi Kim Ngan"	, 1				, 1			, '2019-01-02');

INSERT INTO `Group` (GroupID, GroupName, CreatorID, CreateDate)
VALUES
	(1, "Nhóm sáng tạo 1",11 , '2018-01-02'),
    (2, "Nhóm sáng tạo 2",11 , '2018-04-02'),
    (3, "Nhóm sáng tạo 3",11 , '2019-05-02'),
    (4, "Nhóm sáng tạo 4",11 , '2019-05-02'),
    (5, "Nhóm sáng tạo 5",11 , '2019-05-02'),
	(6, "Nhóm marketting 1",14 , '2018-01-02'),
    (7, "Nhóm marketting 2",14 , '2018-02-02'),
    (8, "Nhóm marketting 3",14 , '2018-03-02'),
    (9, "Nhóm marketting 4",14 , '2019-04-02'),
    (10, "Nhóm đầu tư 1",13 , '2017-01-02');
    
INSERT INTO GroupAccount (GroupID, AccountID, JoinDate)
VALUES
	(1,		11 , 	'2018-01-02'),
    (1,		22 , 	'2018-01-02'),
    (1,		23 , 	'2018-01-02'),
    (1,		24 , 	'2018-01-02'),
    (2, 	25 , 	'2018-04-02'),
    (3, 	11 , 	'2019-05-02'),
    (4, 	11 , 	'2019-05-02'),
    (5, 	11 , 	'2019-05-02'),
	(6, 	14 , 	'2018-01-02'),
    (7, 	14 , 	'2018-02-02'),
    (8, 	14 , 	'2018-03-02'),
    (9, 	14 , 	'2019-04-02'),
    (10, 	13 , 	'2017-01-02');
    
INSERT INTO TypeQuestion (TypeName)
VALUES
	("Trắc nghiệm"),
    ("Điền vào ô trống"),
    ("Điền vào chỗ trống"),
    ("Điền vào khoảng trắng"),
    ("Chọn đúng sai"),
    ("Chọn 1 phương án đúng"),
    ("Chọn nhiều phương án đúng"),
    ("Tự luận ngắn (dưới 500 từ)"),
    ("Tự luận trung bình"),
    ("Tự luận dài (trên 1000 từ)");
    
INSERT INTO CategoryQuestion (CategoryName)
VALUES
	("Ngữ văn"),
    ("Đại số"),
    ("Hình học"),
    ("Lượng giác"),
    ("Giải tích"),
    ("Lịch sử"),
    ("Địa lý"),
    ("Giáo dục công dân"),
    ("Sinh học"),
    ("Tiếng anh");

INSERT INTO Question (Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUES
	("Câu hỏi 1", 10, 21, 1, "2020-05-07"),
    ("Câu hỏi 2", 10, 21, 1, "2020-05-07"),
    ("Câu hỏi 3", 10, 21, 1, "2020-05-07"),
    ("Câu hỏi 4", 10, 21, 1, "2020-05-07"),
    ("Câu hỏi 5", 10, 21, 1, "2020-05-07"),
    ("Câu hỏi 6", 10, 21, 1, "2020-05-07"),
    ("Câu hỏi 7", 10, 21, 1, "2020-05-07"),
    ("Câu hỏi 8", 10, 21, 1, "2020-05-07"),
    ("Câu hỏi 9", 10, 21, 1, "2020-05-07"),
    ("Câu hỏi 10", 10, 21, 1, "2020-05-07");
    
INSERT INTO Answer (Content, QuestionID, isCorrect)
VALUES
	("Câu trả lời 1", 21, 1),
    ("Câu trả lời 1", 22, 1),
    ("Câu trả lời 1", 23, 1),
    ("Câu trả lời 1", 24, 1),
    ("Câu trả lời 1", 25, 1),
    ("Câu trả lời 1", 26, 0),
    ("Câu trả lời 1", 27, 0),
    ("Câu trả lời 1", 28, 0),
    ("Câu trả lời 1", 29, 0),
    ("Câu trả lời 1", 21, 0);
    
INSERT INTO Exam (Code, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES
			("code-1", 'cau-1', 21, "2020-05-07 12:00:00", 1, "2020-05-07"),
			("code-2", 'cau-2', 21, "2020-05-07 12:00:00", 1, "2020-05-07"),
			("code-3", 'cau-3', 21, "2020-05-07 12:00:00", 1, "2020-05-07"),
			("code-4", 'cau-4', 21, "2020-05-07 12:00:00", 1, "2020-05-07"),
			("code-5", 'cau-5', 21, "2020-05-07 12:00:00", 1, "2020-05-07"),
			("code-6", 'cau-6', 21, "2020-05-07 12:00:00", 1, "2020-05-07"),
			("code-7", 'cau-7', 21, "2020-05-07 12:00:00", 1, "2020-05-07"),
			("code-8", 'cau-9', 21, "2020-05-07 12:00:00", 1, "2020-05-07"),
			("code-9", 'cau-9', 21, "2020-05-07 12:00:00", 1, "2020-05-07"),
			("code-10", 'cau-10', 21, "2020-05-07 12:00:00", 1, "2020-05-07");
    
INSERT INTO ExamQuestion (ExamID, questionID)
VALUES
	(1, 21),
    (2, 22),
    (3, 24),
    (4, 25),
    (5, 25),
    (6, 26),
    (7, 27),
    (9, 29),
    (10, 30),
    (8, 28);
    
-- QUESTION 2: Lấy ra tất cả các phòng ban
SELECT * FROM Department; 

-- QUESTION 3: lấy ra id của phòng ban "Sale"
SELECT * FROM Department WHERE DepartmentName LIKE 'Sale';

-- QUESTION 4: lấy ra thông tin account có full name dài nhất và sắp xếp chúng theo thứ tự giảm dần 
SELECT * FROM Account ORDER BY LENGTH(FullName) DESC;

-- QUESTION 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
USE qlbt;
SELECT * FROM Account ORDER BY MAX(LENGTH(FullName));
    
-- QUESTION 6: lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT GroupName 
	FROM `Group`
    WHERE CreateDate < "2019-12-20";
    
-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT questionID 
	FROM Answer
    GROUP BY questionID
    HAVING count(questionID) >= 2;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019    
SELECT `Code` 
	FROM Exam 
	WHERE Duration >= '01:00:00' AND CreateDate < '2019-12-20';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * 
	FROM `Group` 
	ORDER BY CreateDate DESC LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT count(*)
	FROM Account
    WHERE DepartmentID = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT * FROM `Account` WHERE FullName LIKE 'D%o';
    

    

    

    
    