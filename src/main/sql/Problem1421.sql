-- https://leetcode.com/problems/npv-queries/
SELECT
    q.id,
    q.year,
    COALESCE(n.npv, 0) AS npv
FROM queries q LEFT JOIN npv n
    ON n.id = q.id AND n.year = q.year;
