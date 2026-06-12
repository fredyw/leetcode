-- https://leetcode.com/problems/classes-more-than-5-students/
SELECT c.class
FROM (SELECT DISTINCT
    student,
    class
FROM courses) AS c
GROUP BY c.class
HAVING COUNT(c.class) >= 5;
