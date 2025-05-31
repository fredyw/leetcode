-- https://leetcode.com/problems/find-the-start-and-end-number-of-continuous-ranges/description/
with group_logs as (
    select log_id, log_id - dense_rank() over (order by log_id) as grp
    from Logs
    group by log_id
)
select min(log_id) as start_id, max(log_id) as end_id
from group_logs
group by grp
order by start_id;
