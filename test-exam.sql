USE project;
-- b) Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã mua và sắp sếp tăng dần theo số lượng oto đã mua.
SELECT 		c.CustomerID, c.`Name`,c.Address , count(*) AS buyest
FROM 		customer c
LEFT JOIN 	car_order co
ON 			c.CustomerID = co.CustomerID
GROUP BY 	c.CustomerID
ORDER BY 	buyest ASC;

-- C) Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay.
DROP FUNCTION F_Buyest;

DELIMITER $$
CREATE FUNCTION F_Buyest ()
RETURNS VARCHAR(50)
READS SQL DATA
DETERMINISTIC
BEGIN
	DECLARE result VARCHAR(50);

    WITH 
		table_count (Maker, so_luong_ban)
		AS 
		(	
			SELECT 		c.Maker, sum(Amount) AS so_luong_ban
			FROM 		car c
			JOIN 		car_order co
			ON 			c.CarID = co.CarID
			WHERE		YEAR(co.DeliveryDate) = 2000
			GROUP BY 	c.Maker
			ORDER BY 	so_luong_ban DESC
		)
        
    SELECT 		table_count.Maker INTO result
	FROM 		table_count
    WHERE 		table_count.so_luong_ban = 
					(SELECT max(so_luong_ban)
					FROM 	table_count);
	
    RETURN result;
END $$
DELIMITER ;

SELECT F_Buyest();

-- C) Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của những năm trước. In ra số lượng bản ghi đã bị xóa.
DELIMITER $$ 
CREATE PROCEDURE P_Del () 
BEGIN 
	DECLARE length_del INT;
    DECLARE run_var INT;
    
    SET run_var = 0;
    SET length_del = 
		(SELECT count_table.number
		FROM
			(SELECT co.CarID, count(*) AS number
			FROM 	car_order co
			WHERE 	staus = 2 
					AND 
					YEAR(co.OrderDate) <> YEAR(NOW()) AS count_table);
                    
	loop_del: LOOP
		IF run_var = length_del THEN
			LEAVE loop_del;
		END IF;
        
        SET run_var = run_var + 1;
        DELETE 
        FROM car_order co 
        WHERE co.CarID = (
			SELECT max(table_OrderID.OrderID)
			FROM      
				(SELECT co.OrderID
				FROM car_order co
				WHERE staus = 2) AS table_OrderID);
	END LOOP;
    -- in ra man hinh so luong record da del
    SELECT count_table.number
		FROM
			(SELECT c.CarID, count(*) AS number
			FROM car_order c
			WHERE staus = 2) AS count_table;
END $$
DELIMITER ;

select * from car_order;

-- D) Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn
-- hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto và tên hãng sản xuất
DROP PROCEDURE P_order_info;
DELIMITER $$ 
CREATE PROCEDURE P_order_info (IN InCustomerID INT)
BEGIN
	SELECT 		c.`Name`, co.OrderID, co.Amount, car.Maker
	FROM 		car_order co
	LEFT JOIN 	customer c
	ON 			co.CustomerID = c.CustomerID
	LEFT JOIN 	car
	ON 			co.CarID = car.CarID
	WHERE 		c.CustomerID = InCustomerID AND co.staus = 0;
END $$
DELIMITER ;

call P_order_info (1);

-- e) Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ vào database (DeliveryDate < OrderDate + 15).
DELIMITER $$
CREATE TRIGGER T_check 
AFTER INSERT ON car_order
FOR EACH ROW 
BEGIN
	IF DATEDIFF(NEW.DeliveryDate, NEW.OrderDate) < 15 THEN
		SIGNAL SQLSTATE '11111'
        SET MESSAGE_TEXT = 'Không thể INSERT';
	END IF;
END $$
DELIMITER ;