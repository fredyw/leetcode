-- https://leetcode.com/problems/find-products-with-valid-serial-numbers/description/
SELECT
    product_id,
    product_name,
    description
FROM products
WHERE description ~ '\ySN\d{4}\-\d{4}\y'
ORDER BY product_id;
