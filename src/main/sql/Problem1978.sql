-- https://leetcode.com/problems/employees-whose-manager-left-the-company/description/
SELECT employee_id
FROM employees
WHERE
    manager_id NOT IN (SELECT employee_id FROM employees)
    AND salary < 30000
ORDER BY employee_id;
