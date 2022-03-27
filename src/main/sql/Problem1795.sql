-- https://leetcode.com/problems/rearrange-products-table/
select p.product_id, p.store, p.price
from (select product_id, 'store1' as store, store1 as price from products
      union all
      select product_id, 'store2' as store, store2 as price from products
      union all
      select product_id, 'store3' as store, store3 as price from products) as p
where p.price is not null;