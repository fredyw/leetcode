-- https://leetcode.com/problems/find-expensive-cities/description/
select city
from Listings
group by city
having avg(price) > (select avg(price) from Listings)
order by city;