-- https://leetcode.com/problems/last-person-to-fit-in-the-bus/
WITH cummulative_weight AS (
    SELECT
        turn,
        person_name,
        SUM(weight) OVER (ORDER BY turn) AS total_weight
    FROM queue
    ORDER BY turn
)

SELECT person_name
FROM cummulative_weight
WHERE total_weight <= 1000
ORDER BY turn DESC LIMIT 1;
