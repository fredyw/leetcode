-- https://leetcode.com/problems/customers-who-never-order/

-- select c.Name Customers
-- from Customers c
-- where c.Id not in (select o.CustomerId from Orders o);

select c.Name as Customers
from Customers c left join Orders o on c.Id = o.CustomerId
where o.CustomerId is null;
