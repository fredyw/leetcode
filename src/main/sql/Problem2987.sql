-- https://leetcode.com/problems/find-expensive-cities/description/
SELECT city
FROM Listings
GROUP BY city
HAVING AVG(price) > (SELECT AVG(price) FROM Listings)
ORDER BY city;
