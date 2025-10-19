-- https://leetcode.com/problems/project-employees-iii/description/
with max_years as (
    select p.project_id, max(e.experience_years) as max_experience_years
    from Project p join Employee e on p.employee_id = e.employee_id
    group by p.project_id
)
select p.project_id, e.employee_id
from Project p join Employee e on p.employee_id = e.employee_id
               join max_years m on p.project_id = m.project_id
    and e.experience_years = m.max_experience_years;
