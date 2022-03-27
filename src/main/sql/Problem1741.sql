# https://leetcode.com/problems/find-total-time-spent-by-each-employee/
select event_day as day, emp_id, sum(out_time - in_time) as total_time
from employees
group by day, emp_id;