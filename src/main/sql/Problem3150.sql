-- https://leetcode.com/problems/invalid-tweets-ii/description/
select tweet_id
from Tweets
where length(content) > 140
      and regexp_count(content, '@') > 3
      and regexp_count(content, '#') > 3
order by tweet_id;
