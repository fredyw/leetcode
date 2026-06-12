-- https://leetcode.com/problems/premier-league-table-ranking/description/
SELECT
    team_id,
    team_name,
    (wins * 3) + draws AS points,
    RANK() OVER (ORDER BY (wins * 3) + draws DESC) AS position
FROM TeamStats
ORDER BY points DESC, team_name ASC;
