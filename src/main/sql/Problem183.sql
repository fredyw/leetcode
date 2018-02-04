-- https://leetcode.com/problems/customers-who-never-order/
select c.Name Customers
from Customers c
where c.Id not in (select o.CustomerId from Orders o);