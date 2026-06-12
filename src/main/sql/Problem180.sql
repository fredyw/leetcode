-- https://leetcode.com/problems/consecutive-numbers/description/
SELECT DISTINCT s.num AS ConsecutiveNums
FROM (
    SELECT l1.Num AS num
    FROM Logs l1, Logs l2, Logs l3
    WHERE
        l2.id = l1.id + 1 AND l1.Num = l2.Num
        AND l3.id = l2.id + 1 AND l2.Num = l3.Num
) AS s;
