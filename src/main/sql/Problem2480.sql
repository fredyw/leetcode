-- https://leetcode.com/problems/form-a-chemical-bond/description/
SELECT
    e1.symbol AS metal,
    e2.symbol AS nonmetal
FROM Elements e1 CROSS JOIN Elements e2
WHERE
    (e1.type = 'Metal' AND e2.type = 'Nonmetal')
    OR (e2.type = 'Nonmetal' AND e2.type = 'Metal');
