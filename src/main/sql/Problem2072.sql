-- https://leetcode.com/problems/the-winner-university/description/
WITH new_york_excellent AS (
    SELECT COUNT(*) AS count
    FROM newyork
    WHERE score >= 90
),

california_excellent AS (
    SELECT COUNT(*) AS count
    FROM california
    WHERE score >= 90
)

SELECT
    CASE
        WHEN
            (SELECT count FROM new_york_excellent)
            > (SELECT count FROM california_excellent)
            THEN 'New York University'
        WHEN
            (SELECT count FROM new_york_excellent)
            < (SELECT count FROM california_excellent)
            THEN 'California University'
        ELSE 'No Winner'
    END AS winner;
