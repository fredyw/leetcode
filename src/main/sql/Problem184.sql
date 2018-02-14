-- https://leetcode.com/problems/department-highest-salary/
select d.Name as Department, e.Name as Employee, e.Salary as Salary
from Employee e join Department d on e.DepartmentId = d.Id
where (e.DepartmentId, e.Salary) in (select e1.DepartmentId, max(e1.Salary)
                                     from Employee e1
                                     group by e1.DepartmentId);