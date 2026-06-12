-- https://leetcode.com/problems/find-cities-in-each-state/description/
SELECT
    state,
    STRING_AGG(city, ', ' ORDER BY city) AS cities
FROM cities
GROUP BY state
ORDER BY state;
