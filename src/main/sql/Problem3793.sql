-- https://leetcode.com/problems/find-users-with-high-token-usage/description/
WITH user_stats AS (
    SELECT
        user_id,
        COUNT(*) AS prompt_count,
        AVG(tokens) AS avg_tokens
    FROM prompts
    GROUP BY user_id
)
SELECT
    user_id,
    prompt_count,
    ROUND(avg_tokens, 2) AS avg_tokens
FROM user_stats us
WHERE
    prompt_count >= 3
    AND EXISTS (
        SELECT 1
        FROM prompts p
        WHERE p.user_id = us.user_id AND p.tokens > us.avg_tokens
    )
ORDER BY avg_tokens DESC, user_id ASC;
