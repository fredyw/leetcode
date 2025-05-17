-- https://leetcode.com/problems/maximum-transaction-each-day/description/
with max_amount as (
    select day::date as day, max(amount) as max_amount
    from Transactions
    group by day::date
)
select t.transaction_id
from Transactions t join max_amount m
     on t.day::date = m.day
where t.amount = m.max_amount
order by t.transaction_id;