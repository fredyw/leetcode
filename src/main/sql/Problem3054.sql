-- https://leetcode.com/problems/binary-tree-nodes/description/
SELECT
    n,
    'Root' AS type
FROM tree
WHERE p IS null
UNION
SELECT DISTINCT
    p,
    'Inner' AS type
FROM tree
WHERE
    p IS NOT null
    AND p != (
        SELECT n FROM tree
        WHERE p IS null
    )
UNION
SELECT
    n,
    'Leaf' AS type
FROM tree
WHERE
    n NOT IN (
        SELECT p FROM tree
        WHERE p IS NOT null
    )
    AND p IS NOT null
ORDER BY n;
