-- https://leetcode.com/problems/running-total-for-different-genders/
select gender,
       day,
       sum(score_points) over (partition by gender order by day) as total
from Scores
group by gender, day, score_points
order by gender, day;