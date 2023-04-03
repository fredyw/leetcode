-- https://leetcode.com/problems/last-person-to-fit-in-the-bus/
with cummulative_weight as (
    select turn, person_name, sum(weight) over (order by turn) as total_weight
    from queue
    order by turn
)
select person_name
from cummulative_weight
where total_weight <= 1000
order by turn desc limit 1;
