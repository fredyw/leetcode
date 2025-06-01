-- https://leetcode.com/problems/manager-of-the-largest-department/description/
with largest_dep as (
    select dep_id
    from Employees
    group by dep_id
    having count(*) = (
        select max(count) as max
        from (
            select dep_id, count(*)
            from Employees
            group by dep_id
        )
    )
)
select emp_name as manager_name, dep_id
from Employees
where position = 'Manager' and dep_id in (select dep_id from largest_dep)
order by dep_id;
