-- https://leetcode.com/problems/friendly-movies-streamed-last-month/description/
SELECT DISTINCT c.title
FROM tvprogram t JOIN content c
    ON t.content_id = c.content_id
WHERE
    c.kids_content = 'Y'
    AND c.content_type = 'Movies'
    AND t.program_date >= '2020-06-01' AND t.program_date < '2020-07-01';
