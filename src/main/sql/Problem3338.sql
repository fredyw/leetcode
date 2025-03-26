-- https://leetcode.com/problems/second-highest-salary-ii/description/
with ranked_salary as (
    select
        emp_id,
        dept,
        dense_rank() over (partition by dept order by salary desc) as rank
    from employees
)
select emp_id, dept
from ranked_salary
where rank = 2
order by emp_id;