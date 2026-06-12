-- https://leetcode.com/problems/students-with-invalid-departments/description/
SELECT
    id,
    name
FROM Students
WHERE department_id NOT IN (SELECT id FROM Departments);
