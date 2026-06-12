-- https://leetcode.com/problems/market-analysis-i/
SELECT
    u.user_id AS buyer_id,
    u.join_date,
    COUNT(o.order_date) AS orders_in_2019
FROM users u LEFT JOIN orders o
    ON
        u.user_id = o.buyer_id
        AND o.order_date BETWEEN '2019-01-01' AND '2019-12-31'
GROUP BY u.user_id;
