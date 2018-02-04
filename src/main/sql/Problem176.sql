-- https://leetcode.com/problems/second-highest-salary/
select max(e.Salary) as SecondHighestSalary
from (select e1.Salary from Employee e1
where e1.Salary < (select max(e2.Salary) from Employee e2)) as e;