-- https://leetcode.com/problems/managers-with-at-least-5-direct-reports/
with managers as (
    select managerId
    from Employee
    group by managerId
    having count(managerId) >= 5
)
select e.name
from Employee e join managers m
     on e.id = m.managerId;