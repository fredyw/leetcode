-- https://leetcode.com/problems/customers-who-never-order/

-- select c.Name Customers
-- from Customers c
-- where c.Id not in (select o.CustomerId from Orders o);

SELECT c.Name AS Customers
FROM Customers c LEFT JOIN Orders o ON c.Id = o.CustomerId
WHERE o.CustomerId IS null;
