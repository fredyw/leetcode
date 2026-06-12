-- https://leetcode.com/problems/the-first-day-of-the-maximum-recorded-degree-in-each-city/
WITH t AS (
    SELECT
        city_id,
        day,
        degree,
        RANK() OVER (PARTITION BY city_id ORDER BY degree DESC, day ASC) AS rnk
    FROM weather
)
SELECT
    city_id,
    day,
    degree
FROM t
WHERE rnk = 1
ORDER BY city_id;
