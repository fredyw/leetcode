-- https://leetcode.com/problems/employees-whose-manager-left-the-company/description/
SELECT employee_id
FROM Employees
WHERE
    manager_id NOT IN (SELECT employee_id FROM Employees)
    AND salary < 30000
ORDER BY employee_id;
