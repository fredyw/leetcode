-- https://leetcode.com/problems/employees-earning-more-than-their-managers/
SELECT e2.Name AS Employee
FROM Employee e1 JOIN Employee e2 ON e1.Id = e2.ManagerId
WHERE e1.Salary < e2.Salary;
