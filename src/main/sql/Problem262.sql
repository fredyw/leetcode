-- https://leetcode.com/problems/trips-and-users/
SELECT
    t.request_at AS day,
    ROUND(
        SUM(CASE WHEN t.status != 'completed' THEN 1.0 ELSE 0.0 END)
        / COUNT(*),
        2
    ) AS "Cancellation Rate"
FROM trips t
INNER JOIN users c ON t.client_id = c.users_id
INNER JOIN users d ON t.driver_id = d.users_id
WHERE
    c.banned = 'No'
    AND d.banned = 'No'
    AND t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY t.request_at
