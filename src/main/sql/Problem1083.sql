-- https://leetcode.com/problems/sales-analysis-ii/description/
select distinct s.buyer_id
from Product p join Sales s
     on p.product_id = s.product_id
where p.product_name = 'S8'
      and s.buyer_id not in (
          select distinct s.buyer_id
          from Product p join Sales s
               on p.product_id = s.product_id
          where p.product_name = 'iPhone'
      );