-- https://leetcode.com/problems/second-day-verification/description/
SELECT e.user_id
FROM emails e JOIN texts t
    ON e.email_id = t.email_id
WHERE
    t.signup_action = 'Verified'
    AND CAST(e.signup_date AS date) + interval '1 day'
    = CAST(t.action_date AS date)
ORDER BY e.user_id;
