-- https://leetcode.com/problems/find-products-with-three-consecutive-digits/description/
select product_id, name
from products
where name ~ '^\D*\d{3}\D*$'
order by product_id;
