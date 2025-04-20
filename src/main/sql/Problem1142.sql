-- https://leetcode.com/problems/user-activity-for-the-past-30-days-ii/description/
select coalesce(round(avg(count), 2), 0) as average_sessions_per_user
    from (
    select user_id, count(distinct session_id) as count
    from Activity
    where activity_date between '2019-07-28'::date - interval '30 days' and '2019-07-27'
    group by user_id
);