-- https://leetcode.com/problems/students-with-invalid-departments/description/
select id, name
from Students
where department_id not in (select id from Departments);
