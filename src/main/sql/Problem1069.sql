-- https://leetcode.com/problems/product-sales-analysis-ii/
select product_id, sum(quantity) as total_quantity
from sales
group by product_id;