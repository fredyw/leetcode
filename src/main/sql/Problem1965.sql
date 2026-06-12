-- https://leetcode.com/problems/employees-with-missing-information/
WITH u AS (
    SELECT employee_id FROM employees
    UNION
    SELECT employee_id FROM salaries
)

SELECT u.employee_id
FROM u
WHERE
    u.employee_id NOT IN (
        SELECT e.employee_id
        FROM employees e JOIN salaries s
            ON (e.employee_id = s.employee_id)
    )
ORDER BY u.employee_id;
