-- https://leetcode.com/problems/users-that-actively-request-confirmation-messages/
SELECT c1.user_id
FROM Confirmations c1 JOIN Confirmations c2
    ON c1.user_id = c2.user_id
WHERE
    c1.time_stamp != c2.time_stamp
    AND ABS(EXTRACT(EPOCH FROM (c1.time_stamp - c2.time_stamp))) <= 24 * 60 * 60
GROUP BY c1.user_id;
