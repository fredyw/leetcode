-- https://leetcode.com/problems/second-highest-salary/
SELECT MAX(Salary) AS Secondhighestsalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee);
