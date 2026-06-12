-- https://leetcode.com/problems/calculate-salaries/description/
WITH max_salary_per_company AS (
    SELECT
        company_id,
        MAX(salary) AS max_salary
    FROM salaries
    GROUP BY company_id
)
SELECT
    s.company_id,
    s.employee_id,
    s.employee_name,
    ROUND(
        CASE
            WHEN max_salary < 1000 THEN salary
            WHEN
                max_salary >= 1000 AND max_salary < 10000
                THEN (1 - 0.24) * salary
            ELSE (1 - 0.49) * salary
        END
    ) AS salary
FROM salaries s JOIN max_salary_per_company m
    ON s.company_id = m.company_id;
