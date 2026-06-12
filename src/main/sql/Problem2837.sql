-- https://leetcode.com/problems/total-traveled-distance/
SELECT
    u.user_id,
    u.name,
    COALESCE(SUM(r.distance), 0) AS "traveled distance"
FROM users u LEFT JOIN rides r
    ON u.user_id = r.user_id
GROUP BY u.user_id, u.name
ORDER BY u.user_id;
