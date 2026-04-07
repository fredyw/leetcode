-- https://leetcode.com/problems/number-of-accounts-that-did-not-stream/description/
with account_2021 as (
    select account_id
    from Subscriptions
    where start_date <= '2021-12-31' and end_date >= '2021-01-01'
)
select count(*) as accounts_count
from account_2021 a
where not exists (
    select 1
    from Streams s
    where s.account_id = a.account_id
      and s.stream_date >= '2021-01-01'
      and s.stream_date <= '2021-12-31'
);
