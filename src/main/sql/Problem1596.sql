-- https://leetcode.com/problems/the-most-frequently-ordered-products-for-each-customer/description/
with ranked_orders as (
    select customer_id,
           product_id,
           rank() over (partition by customer_id order by count(product_id) desc) as rank
    from Orders
    group by customer_id, product_id
)
select r.customer_id, r.product_id, p.product_name
from ranked_orders r join Products p on r.product_id = p.product_id
where r.rank = 1;
