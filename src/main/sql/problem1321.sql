-- https://leetcode.com/problems/restaurant-growth/
SELECT
    employee_id,
    department_id
FROM employee
WHERE primary_flag = 'Y'
GROUP BY employee_id
UNION
SELECT
    employee_id,
    department_id
FROM employee
GROUP BY employee_id
HAVING COUNT(employee_id) = 1;
