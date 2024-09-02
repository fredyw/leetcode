-- https://leetcode.com/problems/find-the-team-size/description/
with team_count as (
    select team_id, count(*) as team_size
    from Employee
    group by team_id
)
select e.employee_id, c.team_size
from Employee e  join team_count c
     on e.team_id = c.team_id;
