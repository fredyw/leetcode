-- https://leetcode.com/problems/biggest-single-number/
WITH single_numbers AS (
    SELECT num
    FROM mynumbers
    GROUP BY num
    HAVING COUNT(num) = 1
    ORDER BY num DESC
)
SELECT MAX(num) AS num
FROM single_numbers;
