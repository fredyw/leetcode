-- https://leetcode.com/problems/all-the-matches-of-the-league/description/
SELECT
    t1.team_name AS home_team,
    t2.team_name AS away_team
FROM teams t1, teams t2
WHERE t1.team_name != t2.team_name;
