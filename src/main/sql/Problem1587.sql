-- https://leetcode.com/problems/bank-account-summary-ii/
select name, sum(amount) as balance
from users u join transactions t on u.account = t.account
group by name
having sum(amount) > 10000;