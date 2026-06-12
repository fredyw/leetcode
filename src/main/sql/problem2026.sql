-- https://leetcode.com/problems/low-quality-problems/description/
SELECT problem_id
FROM Problems
WHERE (likes / (CAST(likes AS float) + CAST(dislikes AS float))) * 100 < 60
ORDER BY problem_id ASC;
