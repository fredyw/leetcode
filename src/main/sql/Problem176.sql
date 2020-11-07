-- https://leetcode.com/problems/second-highest-salary/
select max(Salary) as SecondHighestSalary
from Employee
where Salary < (select max(Salary) from Employee);
