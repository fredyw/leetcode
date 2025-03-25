-- https://leetcode.com/problems/number-of-comments-per-post/description/
with posts as (
    select distinct sub_id
    from Submissions
    where parent_id is null
), comments as (
    select distinct sub_id, parent_id
    from Submissions
    where parent_id is not null
)
select p.sub_id as post_id, count(c.sub_id) as number_of_comments
from posts p left join comments c on p.sub_id = c.parent_id
group by post_id
order by post_id;
