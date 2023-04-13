-- https://leetcode.com/problems/queries-quality-and-percentage/
select query_name,
       round(avg(rating / position), 2) as quality,
       round(avg(case when rating < 3 then 1 else 0 end) * 100, 2) as poor_query_percentage
from Queries
group by query_name;
