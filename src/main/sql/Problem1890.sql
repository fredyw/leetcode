-- https://leetcode.com/problems/the-latest-login-in-2020/
select user_id, max(time_stamp) as last_stamp
from logins
where year(time_stamp) = 2020
group by user_id;