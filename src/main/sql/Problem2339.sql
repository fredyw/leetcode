-- https://leetcode.com/problems/all-the-matches-of-the-league/description/
select t1.team_name as home_team, t2.team_name as away_team
from Teams t1, Teams t2
where t1.team_name != t2.team_name;
