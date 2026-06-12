-- https://leetcode.com/problems/the-most-frequently-ordered-products-for-each-customer/description/
WITH ranked_orders AS (
    SELECT
        customer_id,
        product_id,
        RANK()
            OVER (PARTITION BY customer_id ORDER BY COUNT(product_id) DESC)
            AS rank
    FROM orders
    GROUP BY customer_id, product_id
)

SELECT
    r.customer_id,
    r.product_id,
    p.product_name
FROM ranked_orders r JOIN products p ON r.product_id = p.product_id
WHERE r.rank = 1;
