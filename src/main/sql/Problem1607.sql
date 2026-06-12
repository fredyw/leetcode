-- https://leetcode.com/problems/sellers-with-no-sales/description/
SELECT seller_name
FROM seller
WHERE
    seller_id NOT IN (
        SELECT DISTINCT seller_id
        FROM orders
        WHERE EXTRACT(YEAR FROM sale_date) = 2020
    )
ORDER BY seller_name;
