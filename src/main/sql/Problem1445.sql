-- https://leetcode.com/problems/apples-oranges/description/
SELECT
    apple_sales.sale_date,
    (apple_sales.sold_num - orange_sales.sold_num) AS diff
FROM
    (SELECT
        sale_date,
        sold_num
    FROM sales
    WHERE fruit = 'apples') AS apple_sales
JOIN
    (SELECT
        sale_date,
        sold_num
    FROM sales
    WHERE fruit = 'oranges')
        AS orange_sales
    ON apple_sales.sale_date = orange_sales.sale_date
ORDER BY apple_sales.sale_date;
