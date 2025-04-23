-- https://leetcode.com/problems/all-people-report-to-the-given-manager/
with recursive Subordinates as (
    select employee_id
    from Employees
    where manager_id = 1 and employee_id != 1
    union all
    select e.employee_id
    from Subordinates s join Employees e
         on s.employee_id = e.manager_id
)
select employee_id
from Subordinates;
