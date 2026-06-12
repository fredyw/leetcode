-- https://leetcode.com/problems/tasks-count-in-the-weekend/description/
SELECT
    (
        SELECT COUNT(*)
        FROM Tasks
        WHERE EXTRACT(DOW FROM Submit_date) IN (0, 6)
    ) AS Weekend_cnt,
    (
        SELECT COUNT(*)
        FROM Tasks
        WHERE EXTRACT(DOW FROM Submit_date) NOT IN (0, 6)
    ) AS Working_cnt;
