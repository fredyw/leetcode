-- https://leetcode.com/problems/calculate-special-bonus/
select employee_id,
       (case
           when employee_id % 2 != 0 and not name like 'M%' then salary
           else 0
        end) as bonus
from employees;