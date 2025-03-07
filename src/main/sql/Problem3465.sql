-- https://leetcode.com/problems/find-products-with-valid-serial-numbers/description/
select product_id,
       product_name,
       description
from products
where description ~ '\ySN\d{4}\-\d{4}\y'
order by product_id;
