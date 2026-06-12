-- https://leetcode.com/problems/rank-scores/
SELECT
    Score,
    (
        SELECT COUNT(DISTINCT Score)
        FROM Scores
        WHERE Score >= S.Score
    ) Rank
FROM Scores S
ORDER BY Score DESC;
