-- https://leetcode.com/problems/premier-league-table-ranking/description/
select
    team_id,
    team_name,
    sum(wins * 3 + draws) as points
from TeamStats
order by points desc, team_name asc;
