-- https://leetcode.com/problems/calculate-the-influence-of-each-salesperson/description/
select sp.salesperson_id, sp.name, coalesce(sum(s.price), 0) as total
from Customer c join Sales s
     on c.customer_id = s.customer_id
     right join Salesperson sp
     on sp.salesperson_id = c.salesperson_id
group by sp.salesperson_id, sp.name;