-- https://leetcode.com/problems/find-the-start-and-end-number-of-continuous-ranges/description/
WITH group_logs AS (
    SELECT
        log_id,
        log_id - DENSE_RANK() OVER (ORDER BY log_id) AS grp
    FROM logs
    GROUP BY log_id
)

SELECT
    MIN(log_id) AS start_id,
    MAX(log_id) AS end_id
FROM group_logs
GROUP BY grp
ORDER BY start_id;
