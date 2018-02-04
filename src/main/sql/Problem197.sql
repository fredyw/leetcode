-- https://leetcode.com/problems/rising-temperature/
select w1.Id
from Weather w1
where w1.Temperature > (select w2.Temperature
                        from Weather w2
                        where w2.Date = subdate(w1.Date, 1)); 