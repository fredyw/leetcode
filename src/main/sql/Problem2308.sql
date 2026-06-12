-- https://leetcode.com/problems/arrange-table-by-gender/description/
WITH t AS (
    SELECT
        ROW_NUMBER() OVER (PARTITION BY gender ORDER BY user_id) AS row_num,
        user_id,
        CASE
            WHEN gender = 'female' THEN 0
            WHEN gender = 'other' THEN 1
            ELSE 2
        END AS gender_order
    FROM genders
)
SELECT
    user_id,
    CASE
        WHEN gender_order = 0 THEN 'female'
        WHEN gender_order = 1 THEN 'other'
        ELSE 'male'
    END AS gender
FROM t
ORDER BY row_num, gender_order;
