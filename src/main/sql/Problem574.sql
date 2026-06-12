-- https://leetcode.com/problems/winning-candidate/description/
WITH vote_count AS (
    SELECT
        c.name,
        COUNT(*) AS count
    FROM Candidate c JOIN Vote v ON v.candidateId = c.id
    GROUP BY c.name
),

max_count AS (
    SELECT MAX(count) AS max_count
    FROM vote_count
)

SELECT name
FROM vote_count
WHERE count = (SELECT max_count FROM max_count);
