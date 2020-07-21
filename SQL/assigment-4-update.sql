-- Assignment_4_update
-- 1, Tính tổng giá trị của các order đã xuất kho (‘shipped’) trong tháng Tám năm 2004 
USE classicmodels;
SELECT SUM(priceEach) AS Total
FROM orders o
LEFT JOIN orderdetails od
ON o.orderNumber = od.orderNumber
WHERE status = 'shipped' AND shippedDate LIKE '2004-08-__'
GROUP BY status;

-- 2, Tính lợi nhuận (profit) thu được từ mỗi khách hàng dựa trên các orders mà họ thực hiện. Liệt kê theo tên khách hàng
SElECT c.customerName, SUM((p.MSRP - buyPrice) * quantityOrdered) AS 'Loi_nhuan'
FROM Customers c
LEFT JOIN orders o
on c.customerNumber = o.customerNumber
LEFT JOIN orderdetails od
on o.orderNumber = od.orderNumber
LEFT JOIN products p
on od.productCode = p.productCode
GROUP BY c.customerNumber
ORDER BY Loi_nhuan DESC;

-- 3, Tính doanh thu (revenue) mà mỗi sản phẩm mang lại. Liệt kê theo tên sản phẩm.
SElECT p.productName, SUM((p.MSRP - buyPrice) * quantityOrdered) AS 'Doanh_thu'
FROM Customers c
LEFT JOIN orders o
on c.customerNumber = o.customerNumber
LEFT JOIN orderdetails od
on o.orderNumber = od.orderNumber
LEFT JOIN products p
on od.productCode = p.productCode
GROUP BY p.productName
ORDER BY Doanh_thu DESC;