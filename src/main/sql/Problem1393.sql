-- https://leetcode.com/problems/capital-gainloss/
WITH buy_stocks AS (
    SELECT
        stock_name,
        SUM(price) AS total_buy_price
    FROM stocks
    WHERE operation = 'Buy'
    GROUP BY stock_name
),

sell_stocks AS (
    SELECT
        stock_name,
        SUM(price) AS total_sell_price
    FROM stocks
    WHERE operation = 'Sell'
    GROUP BY stock_name
)
SELECT
    b.stock_name,
    total_sell_price - total_buy_price AS capital_gain_loss
FROM buy_stocks b JOIN sell_stocks s ON b.stock_name = s.stock_name;
