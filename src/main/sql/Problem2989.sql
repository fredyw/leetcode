-- https://leetcode.com/problems/class-performance/description/
SELECT
    (SELECT MAX(assignment1 + assignment2 + assignment3) FROM scores)
    - (SELECT MIN(assignment1 + assignment2 + assignment3) FROM scores) AS difference_in_score;
