-- https://leetcode.com/problems/number-of-accounts-that-did-not-stream/description/
WITH account_2021 AS (
    SELECT account_id
    FROM Subscriptions
    WHERE start_date <= '2021-12-31' AND end_date >= '2021-01-01'
)

SELECT COUNT(*) AS accounts_count
FROM account_2021 a
WHERE NOT EXISTS (
    SELECT 1
    FROM Streams s
    WHERE
        s.account_id = a.account_id
        AND s.stream_date >= '2021-01-01'
        AND s.stream_date <= '2021-12-31'
);
