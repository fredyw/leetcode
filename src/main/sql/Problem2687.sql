-- https://leetcode.com/problems/bikes-last-time-used/
select bike_number, max(end_time) as end_time
from Bikes
group by bike_number
order by end_time desc;