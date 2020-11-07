-- https://leetcode.com/problems/rising-temperature/

-- select w1.Id
-- from Weather w1
-- where w1.Temperature > (select w2.Temperature
--                         from Weather w2
--                         where w2.Date = subdate(w1.Date, 1));

select w2.Id
from Weather w1 inner join Weather w2 on w1.recordDate = w2.recordDate - interval 1 day
where w1.Temperature < w2.Temperature;
