-- https://leetcode.com/problems/project-employees-iii/description/
WITH max_years AS (
    SELECT
        p.project_id,
        MAX(e.experience_years) AS max_experience_years
    FROM project p JOIN employee e ON p.employee_id = e.employee_id
    GROUP BY p.project_id
)
SELECT
    p.project_id,
    e.employee_id
FROM project p JOIN employee e ON p.employee_id = e.employee_id
JOIN max_years
    m ON p.project_id = m.project_id
AND e.experience_years = m.max_experience_years;
