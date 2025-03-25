-- https://leetcode.com/problems/class-performance/description/
select (select max(assignment1 + assignment2 + assignment3) from Scores) -
       (select min(assignment1 + assignment2 + assignment3) from Scores) as difference_in_score;