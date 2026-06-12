-- https://leetcode.com/problems/user-activity-for-the-past-30-days-i/
SELECT
    activity_date AS day,
    COUNT(DISTINCT user_id) AS active_users
FROM activity
WHERE
    activity_date BETWEEN CAST('2019-07-27' AS DATE)
    - INTERVAL '29 days' AND CAST('2019-07-27' AS DATE)
GROUP BY activity_date;
