-- https://leetcode.com/problems/customer-order-frequency/
with june_orders as (
    select c.customer_id, c.name, sum(o.quantity * p.price) as total_spending
    from Orders o join Customers c on o.customer_id = c.customer_id
        join Product p on o.product_id = p.product_id
    where o.order_date between '2020-06-01' and '2020-06-30'
    group by c.customer_id, c.name
), july_orders as (
    select c.customer_id, c.name, sum(o.quantity * p.price) as total_spending
    from Orders o join Customers c on o.customer_id = c.customer_id
        join Product p on o.product_id = p.product_id
    where o.order_date between '2020-07-01' and '2020-07-31'
    group by c.customer_id, c.name
)
select a.customer_id, a.name
from june_orders a join july_orders b on a.customer_id = b.customer_id
where a.total_spending >= 100 and b.total_spending >= 100;