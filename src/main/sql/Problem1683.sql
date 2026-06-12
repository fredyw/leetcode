-- https://leetcode.com/problems/invalid-tweets/
SELECT tweet_id
FROM tweets
WHERE LENGTH(content) > 15;
