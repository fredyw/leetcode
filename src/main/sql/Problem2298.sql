-- https://leetcode.com/problems/tasks-count-in-the-weekend/description/
SELECT
    (
        SELECT COUNT(*)
        FROM Tasks
        WHERE EXTRACT(DOW FROM submit_date) IN (0, 6)
    ) AS weekend_cnt,
    (
        SELECT COUNT(*)
        FROM Tasks
        WHERE EXTRACT(DOW FROM submit_date) NOT IN (0, 6)
    ) AS working_cnt;
