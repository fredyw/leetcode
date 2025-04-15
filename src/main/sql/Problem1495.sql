-- https://leetcode.com/problems/friendly-movies-streamed-last-month/description/
select distinct c.title
from TVProgram t join Content c
     on t.content_id = c.content_id
where c.kids_content = 'Y'
      and c.content_type = 'Movies'
      and t.program_date >= '2020-06-01' and t.program_date < '2020-07-01';