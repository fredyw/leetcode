-- https://leetcode.com/problems/total-traveled-distance/
select u.user_id,
       u.name,
       coalesce(sum(r.distance), 0) as "traveled distance"
from Users u left join Rides r
     on u.user_id = r.user_id
group by u.user_id, u.name
order by u.user_id;