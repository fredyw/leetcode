-- https://leetcode.com/problems/calculate-product-final-price/description/
SELECT
    p.product_id,
    CASE
        WHEN d.discount IS null THEN p.price
        ELSE p.price - ((p.price * d.discount) / 100.0)
    END AS final_price,
    p.category
FROM Products p LEFT JOIN Discounts d ON p.category = d.category
ORDER BY p.product_id;
