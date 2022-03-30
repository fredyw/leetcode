-- https://leetcode.com/problems/employees-with-missing-information/
with u as (
    select employee_id from employees
    union
    select employee_id from salaries
)
select u.employee_id
from u
where u.employee_id not in (select e.employee_id
                            from employees e join salaries s
                            on (e.employee_id = s.employee_id))
order by u.employee_id;
