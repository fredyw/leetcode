-- https://leetcode.com/problems/customers-who-never-order/

-- select c.Name Customers
-- from Customers c
-- where c.Id not in (select o.CustomerId from Orders o);

SELECT c.name AS customers
FROM customers c LEFT JOIN orders o ON c.id = o.customerid
WHERE o.customerid IS null;
