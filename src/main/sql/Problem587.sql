-- https://leetcode.com/problems/friend-requests-i-overall-acceptance-rate/description/
WITH request_sent_count AS (
    SELECT CAST(COUNT(*) AS decimal) AS count FROM (
        SELECT DISTINCT
            sender_id,
            send_to_id
        FROM FriendRequest
    )
),

request_accepted_count AS (
    SELECT CAST(COUNT(*) AS decimal) AS count FROM (
        SELECT DISTINCT
            requester_id,
            accepter_id
        FROM RequestAccepted
    )
)

SELECT
    CASE
        WHEN (SELECT count FROM request_sent_count) = 0 THEN 0.0
        ELSE ROUND(
            (SELECT count FROM request_accepted_count)
            / (SELECT count FROM request_sent_count), 2
        )
    END AS accept_rate;
