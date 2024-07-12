-- https://leetcode.com/problems/products-price-for-each-store/description/
select product_id,
       max(case when store = 'store1' then price else null end) as store1,
       max(case when store = 'store2' then price else null end) as store2,
       max(case when store = 'store3' then price else null end) as store3
from products
group by product_id;
