-- https://leetcode.com/problems/restaurant-growth/
select employee_id, department_id
from Employee
where primary_flag = 'Y'
group by employee_id
union
select employee_id, department_id
from Employee
group by employee_id
having count(employee_id) = 1;
