-- https://leetcode.com/problems/number-of-comments-per-post/description/
WITH posts AS (
    SELECT DISTINCT sub_id
    FROM submissions
    WHERE parent_id IS null
),

comments AS (
    SELECT DISTINCT
        sub_id,
        parent_id
    FROM submissions
    WHERE parent_id IS NOT null
)

SELECT
    p.sub_id AS post_id,
    COUNT(c.sub_id) AS number_of_comments
FROM posts p LEFT JOIN comments c ON p.sub_id = c.parent_id
GROUP BY post_id
ORDER BY post_id;
