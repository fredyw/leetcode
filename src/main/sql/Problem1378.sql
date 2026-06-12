-- https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/
SELECT
    u.unique_id,
    e.name
FROM Employees e LEFT JOIN EmployeeUNI u ON (e.id = u.id);
