-- https://leetcode.com/problems/convert-date-format/description/
select to_char(day, 'FMDay, FMMonth FMDD, YYYY') as day
from Days;
