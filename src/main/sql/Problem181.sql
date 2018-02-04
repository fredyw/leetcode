-- https://leetcode.com/problems/employees-earning-more-than-their-managers/
select e2.Name as Employee
from Employee e1 join Employee e2 on e1.Id = e2.ManagerId
where e1.Salary < e2.Salary;