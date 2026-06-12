-- https://leetcode.com/problems/activity-participants/description/
WITH activity_count AS (
    SELECT
        activity,
        COUNT(*) AS count
    FROM friends
    GROUP BY activity
),

min_max_stats AS (
    SELECT
        activity,
        count,
        MIN(count) OVER () AS min_count,
        MAX(count) OVER () AS max_count
    FROM activity_count
)

SELECT activity
FROM min_max_stats
WHERE count > min_count AND count < max_count;
