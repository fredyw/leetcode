-- https://leetcode.com/problems/project-employees-ii/description/
with num_employees as (
    select project_id, count(*) as count
    from Project
    group by project_id
), max_employee as (
    select max(count) as max
    from num_employees
)
select project_id
from num_employees
where count = (select max from max_employee);