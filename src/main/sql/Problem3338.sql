-- https://leetcode.com/problems/second-highest-salary-ii/description/
with highest_salary_per_dept as (
    select dept, max(salary) as highest_salary
    from employees
    group by dept
), second_highest_salary_per_dept as (
    select e.dept, max(e.salary) as second_highest_salary
    from employees e join highest_salary_per_dept s
        on e.dept = s.dept and e.salary != s.highest_salary
    group by e.dept
)
select e.emp_id, e.dept
from employees e join second_highest_salary_per_dept s
     on e.dept = s.dept and e.salary = s.second_highest_salary
order by e.emp_id;