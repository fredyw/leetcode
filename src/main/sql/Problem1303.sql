-- https://leetcode.com/problems/find-the-team-size/description/
WITH team_count AS (
    SELECT
        team_id,
        COUNT(*) AS team_size
    FROM employee
    GROUP BY team_id
)
SELECT
    e.employee_id,
    c.team_size
FROM employee e JOIN team_count c
    ON e.team_id = c.team_id;
