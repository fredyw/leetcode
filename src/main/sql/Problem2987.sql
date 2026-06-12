-- https://leetcode.com/problems/find-expensive-cities/description/
SELECT city
FROM listings
GROUP BY city
HAVING AVG(price) > (SELECT AVG(price) FROM listings)
ORDER BY city;
