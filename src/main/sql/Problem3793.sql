-- https://leetcode.com/problems/find-users-with-high-token-usage/description/
with user_stats as (
    select user_id, count(*) as prompt_count, avg(tokens) as avg_tokens
    from prompts
    group by user_id
)
select user_id,
       prompt_count,
       round(avg_tokens, 2) as avg_tokens
from user_stats us
where prompt_count >= 3
    and exists (
        select 1
        from prompts p
        where p.user_id = us.user_id and p.tokens > us.avg_tokens
    )
order by avg_tokens desc, user_id asc;
