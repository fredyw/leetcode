-- https://leetcode.com/problems/invalid-tweets-ii/description/
SELECT tweet_id
FROM tweets
WHERE
    LENGTH(content) > 140
    AND REGEXP_COUNT(content, '@') > 3
    AND REGEXP_COUNT(content, '#') > 3
ORDER BY tweet_id;
