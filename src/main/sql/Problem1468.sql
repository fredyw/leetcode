-- https://leetcode.com/problems/calculate-salaries/description/
with max_salary_per_company as (
    select company_id, max(salary) as max_salary
    from Salaries
    group by company_id
)
select
    s.company_id,
    s.employee_id,
    s.employee_name,
    round(
        case
            when max_salary < 1000 then salary
            when max_salary >= 1000 and max_salary < 10000 then (1 - 0.24) * salary
            else (1 - 0.49) * salary
        end) as salary
from Salaries s join max_salary_per_company m
     on s.company_id = m.company_id;
