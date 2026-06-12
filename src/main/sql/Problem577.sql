-- https://leetcode.com/problems/employee-bonus/description/
SELECT
    e.name,
    b.bonus
FROM Employee e LEFT JOIN Bonus b ON e.empid = b.empid
WHERE b.bonus IS null OR b.bonus < 1000;
