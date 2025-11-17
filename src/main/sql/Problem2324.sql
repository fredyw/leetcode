-- https://leetcode.com/problems/product-sales-analysis-iv/description/
with product_totals as (
    select s.user_id, p.product_id, sum(s.quantity * p.price) as total_price
    from sales s join product p on s.product_id = p.product_id
    group by s.user_id, p.product_id
),
 ranked_totals as (
     select user_id,
            product_id,
            total_price,
            dense_rank() over(partition by user_id order by total_price desc) as rnk
     from product_totals
 )
select user_id, product_id
from ranked_totals
where rnk = 1;
