-- https://leetcode.com/problems/percentage-of-users-attended-a-contest/description/
select r.contest_id,
       round((count(r.user_id) / (select count(*) from Users)) * 100, 2) as percentage
from Users u join Register r on r.user_id = u.user_id
group by r.contest_id
order by percentage desc, r.contest_id;
