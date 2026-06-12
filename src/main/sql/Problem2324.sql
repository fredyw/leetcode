-- https://leetcode.com/problems/product-sales-analysis-iv/description/
WITH product_totals AS (
    SELECT
        s.user_id,
        p.product_id,
        SUM(s.quantity * p.price) AS total_price
    FROM sales s JOIN product p ON s.product_id = p.product_id
    GROUP BY s.user_id, p.product_id
),

ranked_totals AS (
    SELECT
        user_id,
        product_id,
        total_price,
        DENSE_RANK()
            OVER (PARTITION BY user_id ORDER BY total_price DESC)
            AS rnk
    FROM product_totals
)

SELECT
    user_id,
    product_id
FROM ranked_totals
WHERE rnk = 1;
