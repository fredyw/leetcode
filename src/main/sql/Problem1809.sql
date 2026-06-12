-- https://leetcode.com/problems/ad-free-sessions/description/
SELECT p.session_id
FROM Playback p
WHERE p.customer_id NOT IN (
    SELECT a.customer_id
    FROM Ads a
    WHERE p.start_time <= a.timestamp AND a.timestamp <= p.end_time
);
