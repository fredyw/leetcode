-- https://leetcode.com/problems/find-valid-emails/description/
SELECT
    user_id,
    email
FROM Users
WHERE email ~ '^[a-zA-Z0-9_]+@[a-zA-Z]+\.com$'
ORDER BY user_id;
