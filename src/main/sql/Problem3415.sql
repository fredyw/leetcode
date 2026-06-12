-- https://leetcode.com/problems/find-products-with-three-consecutive-digits/description/
SELECT
    product_id,
    name
FROM products
WHERE name ~ '^\D*\d{3}\D*$'
ORDER BY product_id;
