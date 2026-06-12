-- https://leetcode.com/problems/exchange-seats/
SELECT
    (CASE
        WHEN MOD(id, 2) != 0 AND cnt.c != id THEN id + 1
        WHEN MOD(id, 2) != 0 AND cnt.c = id THEN id
        ELSE id - 1
    END) AS id,
    student
FROM seat, (SELECT COUNT(*) AS c FROM seat) AS cnt
ORDER BY id;
