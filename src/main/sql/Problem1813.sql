-- https://leetcode.com/problems/maximum-transaction-each-day/description/
WITH max_amount AS (
    SELECT
        day::date AS day,
        MAX(amount) AS max_amount
    FROM transactions
    GROUP BY day::date
)

SELECT t.transaction_id
FROM transactions t JOIN max_amount m
    ON t.day::date = m.day
WHERE t.amount = m.max_amount
ORDER BY t.transaction_id;
