-- https://leetcode.com/problems/sales-analysis-i/description/
WITH aggregated_sales AS (
    SELECT
        seller_id,
        SUM(price) AS total_price
    FROM sales
    GROUP BY seller_id
)
SELECT seller_id
FROM aggregated_sales
WHERE total_price = (SELECT MAX(total_price) FROM aggregated_sales)
GROUP BY seller_id;
