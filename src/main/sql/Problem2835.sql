-- https://leetcode.com/problems/highest-salaries-difference/description/
select abs((
    select max(salary)
    from Salaries
    where department = 'Engineering'
) - (
    select max(salary)
    from Salaries
    where department = 'Marketing'
)) as salary_difference;