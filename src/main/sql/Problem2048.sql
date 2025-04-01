-- https://leetcode.com/problems/drop-type-1-orders-for-customers-with-type-0-orders/description/
-- with customer_with_order_0_and_1 as (
--     select customer_id
--     from Orders
--     where order_type = 1
--     intersect
--     select customer_id
--     from Orders
--     where order_type = 0
-- )
-- select o.order_id, o.customer_id, o.order_type
-- from Orders o join customer_with_order_0_and_1 c
--      on o.customer_id = c.customer_id
-- where o.order_type != 1
-- union
-- select order_id, customer_id, order_type
-- from Orders
-- where customer_id not in (
--     select customer_id from customer_with_order_0_and_1
-- );

select order_id, customer_id, order_type
from Orders
where order_type = 0
      or (order_type = 1 and customer_id not in (
	      select customer_id from orders where order_type = 0));