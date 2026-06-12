-- https://leetcode.com/problems/managers-with-at-least-5-direct-reports/
WITH managers AS (
    SELECT managerId
    FROM Employee
    GROUP BY managerId
    HAVING COUNT(managerId) >= 5
)

SELECT e.name
FROM Employee e JOIN managers m
    ON e.id = m.managerId;
