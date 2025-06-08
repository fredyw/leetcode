-- https://leetcode.com/problems/find-books-with-no-available-copies/description/
with borrow_counts as (
    select book_id, count(*) as total_borrows
    from borrowing_records
    where return_date is null
    group by book_id
)
select l.book_id,
       l.title,
       l.author,
       l.genre,
       l.publication_year,
       l.total_copies as current_borrowers
from library_books l join borrow_counts b
     on l.book_id = b.book_id
where l.total_copies = b.total_borrows
order by l.total_copies desc, l.title asc;