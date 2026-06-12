-- https://leetcode.com/problems/running-total-for-different-genders/
SELECT
    gender,
    day,
    SUM(score_points) OVER (PARTITION BY gender ORDER BY day) AS total
FROM Scores
GROUP BY gender, day, score_points
ORDER BY gender, day;
