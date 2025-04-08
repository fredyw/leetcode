-- https://leetcode.com/problems/users-that-actively-request-confirmation-messages/
select c1.user_id
from Confirmations c1 join Confirmations c2
     on c1.user_id = c2.user_id
where c1.time_stamp != c2.time_stamp
      and abs(extract(epoch from (c1.time_stamp - c2.time_stamp))) <= 24 * 60 * 60
group by c1.user_id;