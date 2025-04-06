-- https://leetcode.com/problems/ad-free-sessions/description/
select p.session_id
from Playback p
where p.customer_id not in (
    select a.customer_id
    from Ads a
    where p.start_time <= a.timestamp and a.timestamp <= p.end_time
);