-- https://leetcode.com/problems/percentage-of-users-attended-a-contest/description/
SELECT
    r.contest_id,
    ROUND((COUNT(r.user_id) / (SELECT COUNT(*) FROM Users)) * 100, 2)
        AS percentage
FROM Users u JOIN Register r ON r.user_id = u.user_id
GROUP BY r.contest_id
ORDER BY percentage DESC, r.contest_id;
