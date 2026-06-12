-- https://leetcode.com/problems/grand-slam-titles/
WITH grand_slams_won AS (
    SELECT
        player_id,
        player_name,
        (SELECT
            SUM(CASE WHEN Wimbledon = player_id THEN 1 ELSE 0 END)
            + SUM(CASE WHEN Fr_open = player_id THEN 1 ELSE 0 END)
            + SUM(CASE WHEN US_open = player_id THEN 1 ELSE 0 END)
            + SUM(CASE WHEN AU_open = player_id THEN 1 ELSE 0 END)
        FROM Championships) AS grand_slams_count
    FROM Players
)

SELECT
    player_id,
    player_name,
    grand_slams_count
FROM grand_slams_won
WHERE grand_slams_count > 0;
