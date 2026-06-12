-- https://leetcode.com/problems/user-activity-for-the-past-30-days-ii/description/
SELECT COALESCE(ROUND(AVG(count), 2), 0) AS average_sessions_per_user
FROM (
    SELECT
        user_id,
        COUNT(DISTINCT session_id) AS count
    FROM Activity
    WHERE
        activity_date BETWEEN '2019-07-28'::date
        - interval '30 days' AND '2019-07-27'
    GROUP BY user_id
);
