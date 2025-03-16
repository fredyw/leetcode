-- https://leetcode.com/problems/the-number-of-rich-customers/description/
select count(distinct customer_id) as rich_count
from Store
where amount > 500;
