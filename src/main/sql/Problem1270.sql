-- https://leetcode.com/problems/all-people-report-to-the-given-manager/
WITH RECURSIVE Subordinates AS (
    SELECT employee_id
    FROM Employees
    WHERE manager_id = 1 AND employee_id != 1
    UNION ALL
    SELECT e.employee_id
    FROM Subordinates s JOIN Employees e
        ON s.employee_id = e.manager_id
)

SELECT employee_id
FROM Subordinates;
