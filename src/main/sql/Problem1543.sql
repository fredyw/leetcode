-- https://leetcode.com/problems/fix-product-name-format/
select lower(trim(product_name)) as product_name,
       date_format(sale_date, '%Y-%m') as sale_date,
       count(*) as total
from Sales
group by 1, 2
order by 1, 2;