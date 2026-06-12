-- https://leetcode.com/problems/sellers-with-no-sales/description/
SELECT seller_name
FROM Seller
WHERE
    seller_id NOT IN (
        SELECT DISTINCT seller_id
        FROM Orders
        WHERE EXTRACT(YEAR FROM sale_date) = 2020
    )
ORDER BY seller_name;
