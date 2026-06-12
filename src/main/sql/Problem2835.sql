-- https://leetcode.com/problems/highest-salaries-difference/description/
SELECT ABS((
    SELECT MAX(salary)
    FROM salaries
    WHERE department = 'Engineering'
) - (
    SELECT MAX(salary)
    FROM salaries
    WHERE department = 'Marketing'
)) AS salary_difference;
