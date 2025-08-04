-- https://leetcode.com/problems/accepted-candidates-from-the-interviews/
select c.candidate_id
from Candidates c
where c.years_of_exp >= 2
  and (select sum(score)
       from Rounds r
       where r.interview_id = c.interview_id) > 15;
