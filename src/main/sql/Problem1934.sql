-- https://leetcode.com/problems/confirmation-rate/
SELECT
    s.user_id,
    COALESCE(ROUND(SUM(c.action = 'confirmed') / COUNT(c.action), 2), 0)
        AS confirmation_rate
FROM signups s LEFT JOIN confirmations c ON s.user_id = c.user_id
GROUP BY s.user_id;
