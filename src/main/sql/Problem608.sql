-- https://leetcode.com/problems/tree-node/
SELECT
    id,
    'Root' AS type
FROM tree
WHERE p_id IS null
UNION
SELECT DISTINCT
    p_id,
    'Inner' AS type
FROM tree
WHERE
    p_id IS NOT null
    AND p_id != (
        SELECT id FROM tree
        WHERE p_id IS null
    )
UNION
SELECT
    id,
    'Leaf' AS type
FROM tree
WHERE
    id NOT IN (
        SELECT p_id FROM tree
        WHERE p_id IS NOT null
    )
    AND p_id IS NOT null
ORDER BY id;
