-- https://leetcode.com/problems/apples-oranges/description/
select apple_sales.sale_date,
       (apple_sales.sold_num - orange_sales.sold_num) as diff
from (select sale_date, sold_num from Sales where fruit = 'apples') as apple_sales
     join
     (select sale_date, sold_num from Sales where fruit = 'oranges') as orange_sales
     on apple_sales.sale_date = orange_sales.sale_date
order by apple_sales.sale_date;