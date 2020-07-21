-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE VIEW sale_view AS
SELECT * FROM account
WHERE Departmentid = 2;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE VIEW account_view AS
SELECT new_table.a, new_table.b as max
FROM (
SELECT a.AccountID AS a, count(*) AS b
FROM `groupaccount`  ga
LEFT JOIN `account` a
ON ga.AccountID = a.AccountID
GROUP BY a.AccountID
HAVING b = max(b)
ORDER BY b DESC) AS new_table;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 30 từ được coi là quá dài) và xóa nó đi
CREATE VIEW del_long_content_view AS
DELETE FROM question 
WHERE QuestionID = count_table.QuestionID
FROM (
SELECT QuestionID,length(Content) AS `lengthOfContent`
FROM question
WHERE length(Content) > 30
) AS count_table;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE VIEW department_view AS
SELECT *, max(count_table.member)
FROM
(SELECT d.DepartmentID, count(*) AS `member`
FROM department d
LEFT JOIN `account` a
ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentID) AS count_table;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE VIEW nguyen_view AS
SELECT q.QuestionID, q.Content, a.AccountID, a.FullName
FROM question q
LEFT JOIN account a
ON q.CreatorID = a.AccountID
WHERE a.FullName LIKE "Nguyen%"
ORDER BY a.FullName DESC;
