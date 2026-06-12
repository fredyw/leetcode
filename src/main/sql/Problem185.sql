-- https://leetcode.com/problems/department-top-three-salaries/
SELECT
    d.name AS department,
    e1.name AS employee,
    e1.salary
FROM employee e1 JOIN department d ON e1.departmentid = d.id
WHERE 3 > (
    SELECT COUNT(DISTINCT e2.salary)
    FROM employee e2
    WHERE e2.salary > e1.salary AND e1.departmentid = e2.departmentid
);
