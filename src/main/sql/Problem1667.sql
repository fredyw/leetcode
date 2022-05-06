-- https://leetcode.com/problems/fix-names-in-a-table/
select user_id,
       concat(upper(substring(name, 1, 1)), lower(substring(name from 2))) as name
from users
order by user_id;