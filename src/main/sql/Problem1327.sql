-- https://leetcode.com/problems/list-the-products-ordered-in-a-period/description/
select p.product_name, sum(o.unit) as unit
from Products p join Orders o on p.product_id = o.product_id
where extract(year from o.order_date) = 2020
      and extract(month from o.order_date) = 2
group by p.product_id
having sum(o.unit) >= 100;