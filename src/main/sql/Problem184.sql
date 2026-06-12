-- https://leetcode.com/problems/department-highest-salary/
SELECT
    d.Name AS Department,
    e.Name AS Employee,
    e.Salary AS Salary
FROM Employee e JOIN Department d ON e.DepartmentId = d.Id
WHERE (
    e.DepartmentId, e.Salary) IN (
    SELECT
        e1.DepartmentId,
        MAX(e1.Salary)
    FROM Employee e1
    GROUP BY e1.DepartmentId
);
