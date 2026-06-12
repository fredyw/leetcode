-- https://leetcode.com/problems/list-the-products-ordered-in-a-period/description/
SELECT
    p.product_name,
    SUM(o.unit) AS unit
FROM products p JOIN orders o ON p.product_id = o.product_id
WHERE
    EXTRACT(YEAR FROM o.order_date) = 2020
    AND EXTRACT(MONTH FROM o.order_date) = 2
GROUP BY p.product_id
HAVING SUM(o.unit) >= 100;
