-- https://leetcode.com/problems/calculate-compressed-mean/description/
SELECT
    ROUND(
        SUM(item_count * order_occurrences)
        / CAST(SUM(order_occurrences) AS decimal),
        2
    )
        AS average_items_per_order
FROM orders;
