-- https://leetcode.com/problems/calculate-product-final-price/description/
select p.product_id,
       case
           when d.discount is null then p.price
           else p.price - ((p.price * d.discount) / 100.0)
           end as final_price,
       p.category
from Products p left join Discounts d on p.category = d.category
order by p.product_id;
