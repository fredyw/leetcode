-- https://leetcode.com/problems/find-valid-emails/description/
select user_id, email
from Users
where email ~ '^[a-zA-Z0-9_]+@[a-zA-Z]+\.com$'
order by user_id;