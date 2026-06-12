-- https://leetcode.com/problems/arrange-table-by-gender/description/
WITH t AS (
    SELECT
        user_id,
        gender,
        ROW_NUMBER() OVER (PARTITION BY gender ORDER BY user_id) AS row_num,
        CASE
            WHEN gender = 'female' THEN 0
            WHEN gender = 'other' THEN 1
            ELSE 2
        END AS gender_order
    FROM genders
)
SELECT
    user_id,
    gender
FROM t
ORDER BY row_num, gender_order;
