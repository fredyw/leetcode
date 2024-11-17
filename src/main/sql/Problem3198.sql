-- https://leetcode.com/problems/find-cities-in-each-state/description/
select state, string_agg(city, ', ') within group (order by city) as cities
from cities
group by state
order by state;
