-- https://leetcode.com/problems/customer-order-frequency/
select c.customer_id, c.name
from Customers c join Orders o on c.customer_id = o.customer_id
     join Product p ON o.product_id = p.product_id
group by c.customer_id, c.name
having sum(case when o.order_date between '2020-06-01' and '2020-06-30' then o.quantity * p.price else 0 end) >= 100
   and sum(case when o.order_date between '2020-07-01' and '2020-07-31' then o.quantity * p.price else 0 end) >= 100;