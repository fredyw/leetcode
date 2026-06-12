-- https://leetcode.com/problems/consecutive-numbers/description/
SELECT DISTINCT s.num AS consecutivenums
FROM (
    SELECT l1.num AS num
    FROM logs l1, logs l2, logs l3
    WHERE
        l2.id = l1.id + 1 AND l1.num = l2.num
        AND l3.id = l2.id + 1 AND l2.num = l3.num
) AS s;
