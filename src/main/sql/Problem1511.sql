-- https://leetcode.com/problems/customer-order-frequency/
SELECT
    c.customer_id,
    c.name
FROM customers c JOIN orders o ON c.customer_id = o.customer_id
JOIN product p ON o.product_id = p.product_id
GROUP BY c.customer_id, c.name
HAVING
    SUM(
        CASE
            WHEN
                o.order_date BETWEEN '2020-06-01' AND '2020-06-30'
                THEN o.quantity * p.price
            ELSE 0
        END
    )
    >= 100
    AND SUM(CASE WHEN o.order_date BETWEEN '2020-07-01' AND '2020-07-31' THEN o.quantity * p.price ELSE 0 END) >= 100;
