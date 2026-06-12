-- https://leetcode.com/problems/rising-temperature/

-- select w1.Id
-- from Weather w1
-- where w1.Temperature > (select w2.Temperature
--                         from Weather w2
--                         where w2.Date = subdate(w1.Date, 1));

SELECT w2.id
FROM weather w1
INNER JOIN weather w2 ON w1.recorddate = w2.recorddate - INTERVAL '1 day'
WHERE w1.temperature < w2.temperature;
