-- https://leetcode.com/problems/friday-purchases-i/description/
select ceil(extract(day from purchase_date) / 7) as week_of_month,
       purchase_date,
       sum(amount_spend) as total_amount
from Purchases
where extract(dow from purchase_date) = 5
group by week_of_month, purchase_date
order by week_of_month;
