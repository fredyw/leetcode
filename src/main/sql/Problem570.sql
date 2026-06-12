-- https://leetcode.com/problems/managers-with-at-least-5-direct-reports/
WITH managers AS (
    SELECT managerid
    FROM employee
    GROUP BY managerid
    HAVING COUNT(managerid) >= 5
)

SELECT e.name
FROM employee e JOIN managers m
    ON e.id = m.managerid;
