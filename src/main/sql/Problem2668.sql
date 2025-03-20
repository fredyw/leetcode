-- https://leetcode.com/problems/find-latest-salaries/description/
select emp_id, firstname, lastname, max(salary) as salary, department_id
from Salary
group by emp_id, firstname, lastname, department_id
order by emp_id;