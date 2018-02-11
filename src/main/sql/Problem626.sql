-- https://leetcode.com/problems/exchange-seats/
select (case
        when mod(id, 2) != 0 and cnt.c != id then id + 1
        when mod(id, 2) != 0 and cnt.c = id then id
        else id - 1
        end) as id, student
from seat, (select count(*) as c from seat) as cnt
order by id;