-- https://leetcode.com/problems/immediate-food-delivery-i/description/
WITH immediate_orders AS (
    SELECT CAST(COUNT(*) AS decimal) AS count
    FROM Delivery
    WHERE order_date = customer_pref_delivery_date
),

total_orders AS (
    SELECT CAST(COUNT(*) AS decimal) AS count
    FROM Delivery
)

SELECT ROUND(
    (
        (SELECT count FROM immediate_orders
        ) / (SELECT count FROM total_orders
        ) * 100
    ),
    2
) AS immediate_percentage;
