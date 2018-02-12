-- https://leetcode.com/problems/rank-scores/
select Score, (select count(distinct Score)
               from Scores
               where Score >= s.Score) Rank
from Scores s
order by Score desc;