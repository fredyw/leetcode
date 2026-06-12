-- https://leetcode.com/problems/fix-product-name-format/
SELECT
    LOWER(TRIM(product_name)) AS product_name,
    TO_CHAR(sale_date, 'YYYY-MM') AS sale_date,
    COUNT(*) AS total
FROM sales
GROUP BY 1, 2
ORDER BY 1, 2;
