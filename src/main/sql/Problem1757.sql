-- https://leetcode.com/problems/recyclable-and-low-fat-products/
select product_id
from products
where low_fats = 'Y' and recyclable = 'Y';