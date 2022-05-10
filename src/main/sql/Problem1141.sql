-- https://leetcode.com/problems/user-activity-for-the-past-30-days-i/
select activity_date as day, count(distinct user_id) as active_users
from activity
where activity_date between date_sub('2019-07-27', interval 29 day) and'2019-07-27'
group by activity_date;