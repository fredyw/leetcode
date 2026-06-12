-- https://leetcode.com/problems/convert-date-format/description/
SELECT TO_CHAR(day, 'FMDay, FMMonth FMDD, YYYY') AS day
FROM days;
