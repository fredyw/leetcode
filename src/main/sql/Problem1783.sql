-- https://leetcode.com/problems/grand-slam-titles/
with grand_slams_won as (
    select
        player_id,
        player_name,
        (select sum(case when Wimbledon = player_id then 1 else 0 end) +
                sum(case when Fr_open = player_id then 1 else 0 end) +
                sum(case when US_open = player_id then 1 else 0 end) +
                sum(case when AU_open = player_id then 1 else 0 end)
         from Championships) as grand_slams_count
    from Players
)
select player_id, player_name, grand_slams_count
from grand_slams_won
where grand_slams_count > 0;