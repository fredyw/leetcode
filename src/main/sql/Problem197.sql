-- https://leetcode.com/problems/rising-temperature/

-- select w1.Id
-- from Weather w1
-- where w1.Temperature > (select w2.Temperature
--                         from Weather w2
--                         where w2.Date = subdate(w1.Date, 1));

SELECT w2.Id
FROM Weather w1
INNER JOIN Weather w2 ON w1.recordDate = w2.recordDate - INTERVAL 1 DAY
WHERE w1.Temperature < w2.Temperature;
