-- https://leetcode.com/problems/calculate-special-bonus/
SELECT
    employee_id,
    (CASE
        WHEN employee_id % 2 != 0 AND NOT name LIKE 'M%' THEN salary
        ELSE 0
    END) AS bonus
FROM employees;
