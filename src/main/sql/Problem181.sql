-- https://leetcode.com/problems/employees-earning-more-than-their-managers/
SELECT e2.name AS employee
FROM employee e1 JOIN employee e2 ON e1.id = e2.managerid
WHERE e1.salary < e2.salary;
