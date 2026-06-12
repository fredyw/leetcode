-- https://leetcode.com/problems/all-people-report-to-the-given-manager/
WITH RECURSIVE Subordinates AS (
    SELECT Employee_id
    FROM Employees
    WHERE Manager_id = 1 AND Employee_id != 1
    UNION ALL
    SELECT E.Employee_id
    FROM Subordinates S JOIN Employees E
        ON S.Employee_id = E.Manager_id
)

SELECT Employee_id
FROM Subordinates;
