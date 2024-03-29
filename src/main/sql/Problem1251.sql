-- https://leetcode.com/problems/average-selling-price/
select p.product_id,
       round(sum(p.price * u.units) / sum(u.units), 2) as average_price
from Prices p join UnitsSold u on p.product_id = u.product_id
where u.purchase_date between p.start_date and p.end_date
group by p.product_id;
