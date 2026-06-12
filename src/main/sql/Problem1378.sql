-- https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/
SELECT
    u.unique_id,
    e.name
FROM employees e LEFT JOIN employeeuni u ON (e.id = u.id);
