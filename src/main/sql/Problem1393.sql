-- https://leetcode.com/problems/capital-gainloss/
with buy_stocks as (select stock_name, sum(price) as total_buy_price
                    from stocks
                    where operation = 'Buy'
                    group by stock_name),
     sell_stocks as (select stock_name, sum(price) as total_sell_price
                     from stocks
                     where operation = 'Sell'
                     group by stock_name)
select b.stock_name, total_sell_price - total_buy_price as capital_gain_loss
from buy_stocks b join sell_stocks s on b.stock_name = s.stock_name;