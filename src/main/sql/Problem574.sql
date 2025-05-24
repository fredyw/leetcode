-- https://leetcode.com/problems/winning-candidate/description/
with vote_count as (
    select c.name, count(*) as count
    from Candidate c join Vote v on v.candidateId = c.id
    group by c.name
), max_count as (
    select max(count) as max_count
    from vote_count
)
select name
from vote_count
where count = (select max_count from max_count);