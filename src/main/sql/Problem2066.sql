-- https://leetcode.com/problems/account-balance/description/
select account_id,
       day,
       sum(case when type = 'Deposit' then amount else -amount end)
           over (partition by account_id order by day) as balance
from Transactions
order by account_id, day;