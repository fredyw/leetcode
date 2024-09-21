-- https://leetcode.com/problems/low-quality-problems/description/
select problem_id
from Problems
where (likes / (cast(likes as float) + cast(dislikes as float))) * 100 < 60
order by problem_id asc;
