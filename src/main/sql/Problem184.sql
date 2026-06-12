-- https://leetcode.com/problems/department-highest-salary/
SELECT
    d.name AS department,
    e.name AS employee,
    e.salary AS salary
FROM employee e JOIN department d ON e.departmentid = d.id
WHERE (
    e.departmentid, e.salary) IN (
    SELECT
        e1.departmentid,
        MAX(e1.salary)
    FROM employee e1
    GROUP BY e1.departmentid
);
