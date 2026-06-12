-- https://leetcode.com/problems/reported-posts/
SELECT
    extra AS report_reason,
    COUNT(DISTINCT post_id) AS report_count
FROM actions
WHERE
    extra IS NOT null
    AND action_date = '2019-07-04'
    AND action = 'report'
GROUP BY extra;
