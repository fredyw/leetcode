-- https://leetcode.com/problems/count-apples-and-oranges/description/
WITH t AS (
    SELECT
        apple_count,
        orange_count
    FROM boxes
    WHERE chest_id IS null
    UNION ALL
    SELECT
        (b.apple_count + c.apple_count) AS apple_count,
        (b.orange_count + c.orange_count) AS orange_count
    FROM boxes b JOIN chests c ON b.chest_id = c.chest_id
)

SELECT
    SUM(apple_count) AS apple_count,
    SUM(orange_count) AS orange_count
FROM t;
