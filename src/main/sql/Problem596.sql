-- https://leetcode.com/problems/classes-more-than-5-students/
select c.class
from (select distinct student, class from courses) as c
group by c.class
having count(c.class) >= 5;