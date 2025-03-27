-- https://leetcode.com/problems/reported-posts/
select extra as report_reason, count(distinct post_id) as report_count 
from Actions
where extra is not null
      and action_date = '2019-07-04' 
      and action = 'report'
group by extra;