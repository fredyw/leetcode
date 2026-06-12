-- https://leetcode.com/problems/number-of-calls-between-two-persons/description/
WITH t AS (
    SELECT
        CASE WHEN from_id < to_id THEN from_id ELSE to_id END AS person1,
        CASE WHEN from_id > to_id THEN from_id ELSE to_id END AS person2,
        duration
    FROM calls
)
SELECT
    person1,
    person2,
    COUNT(*) AS call_count,
    SUM(duration) AS total_duration
FROM t
GROUP BY person1, person2;
