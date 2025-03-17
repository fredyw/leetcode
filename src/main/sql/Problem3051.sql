-- https://leetcode.com/problems/find-candidates-for-data-scientist-position/description/
select candidate_id
from Candidates
where skill in ('Python', 'Tableau', 'PostgreSQL')
group by candidate_id
having count(skill) >= 3
order by candidate_id;