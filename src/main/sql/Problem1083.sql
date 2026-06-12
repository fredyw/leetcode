-- https://leetcode.com/problems/sales-analysis-ii/description/
SELECT DISTINCT s.buyer_id
FROM Product p JOIN Sales s
    ON p.product_id = s.product_id
WHERE
    p.product_name = 'S8'
    AND s.buyer_id NOT IN (
        SELECT DISTINCT s.buyer_id
        FROM Product p JOIN Sales s
            ON p.product_id = s.product_id
        WHERE p.product_name = 'iPhone'
    );
