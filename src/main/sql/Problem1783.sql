-- https://leetcode.com/problems/grand-slam-titles/
WITH grand_slams_won AS (
    SELECT
        player_id,
        player_name,
        (SELECT
            SUM(CASE WHEN wimbledon = player_id THEN 1 ELSE 0 END)
            + SUM(CASE WHEN fr_open = player_id THEN 1 ELSE 0 END)
            + SUM(CASE WHEN us_open = player_id THEN 1 ELSE 0 END)
            + SUM(CASE WHEN au_open = player_id THEN 1 ELSE 0 END)
        FROM championships) AS grand_slams_count
    FROM players
)

SELECT
    player_id,
    player_name,
    grand_slams_count
FROM grand_slams_won
WHERE grand_slams_count > 0;
