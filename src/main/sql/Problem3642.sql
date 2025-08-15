-- https://leetcode.com/problems/find-books-with-polarized-opinions/description/
select b.book_id,
       b.title,
       b.author,
       b.genre,
       b.pages,
       max(s.session_rating) - min(s.session_rating) as rating_spread,
       round(sum(case when s.session_rating <= 2 or s.session_rating >= 4 then 1 else 0 end) * 1.0 /
             count(*), 2) as polarization_score
from books b join reading_sessions s on b.book_id = s.book_id
where exists (select 1 from reading_sessions where book_id = s.book_id and session_rating <= 2)
  and exists (select 1 from reading_sessions where book_id = s.book_id and session_rating >= 4)
group by b.book_id
having count(*) >= 5
   and round(sum(case when s.session_rating <= 2 or s.session_rating >= 4 then 1 else 0 end) * 1.0 /
             count(*), 2) >= 0.6
order by polarization_score desc, b.title desc;
