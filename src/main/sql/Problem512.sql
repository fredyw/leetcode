-- https://leetcode.com/problems/game-play-analysis-ii/description/
select distinct on (player_id) player_id, device_id
from Activity
order by player_id, event_date;
