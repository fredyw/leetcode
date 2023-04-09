-- https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/
select u.unique_id, e.name
from Employees e left join EmployeeUNI u on (e.id = u.id);
