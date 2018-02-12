-- https://leetcode.com/problems/consecutive-numbers/description/
select distinct(s.num) as ConsecutiveNums
from (select l1.Num as num
      from Logs l1, Logs l2, Logs l3
      where l2.id = l1.id + 1 and l1.Num = l2.Num and
            l3.id = l2.id + 1 and l2.Num = l3.Num) as s;