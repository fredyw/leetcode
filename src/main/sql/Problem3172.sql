-- https://leetcode.com/problems/second-day-verification/description/
select e.user_id
from emails e join texts t
     on e.email_id = t.email_id
where t.signup_action = 'Verified'
      and cast(e.signup_date as date) + interval '1 day' = cast(t.action_date as date)
order by e.user_id;