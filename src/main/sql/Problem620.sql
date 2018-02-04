-- https://leetcode.com/problems/not-boring-movies/
select id, movie, description, rating
from cinema
where id % 2 != 0 and description != 'boring'
group by rating desc;