-- https://leetcode.com/problems/unique-orders-and-customers-per-month/description/
select to_char(order_date, 'YYYY-MM') as month,
       count(*) as order_count,
       count(distinct customer_id) as customer_count
from Orders
where invoice > 20
group by month;