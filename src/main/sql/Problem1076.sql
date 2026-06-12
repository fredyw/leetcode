-- https://leetcode.com/problems/project-employees-ii/description/
WITH num_employees AS (
    SELECT
        project_id,
        COUNT(*) AS count
    FROM project
    GROUP BY project_id
),

max_employee AS (
    SELECT MAX(count) AS max
    FROM num_employees
)
SELECT project_id
FROM num_employees
WHERE count = (SELECT max FROM max_employee);
