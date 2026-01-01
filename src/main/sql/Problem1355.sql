-- https://leetcode.com/problems/activity-participants/description/
with activity_count as (
    select activity, count(*) as count
    from Friends
    group by activity
),
min_max_stats as (
    select activity,
           count,
           min(count) over() as min_count,
           max(count) over() as max_count
    from activity_count
)
select activity
from min_max_stats
where count > min_count and count < max_count;
