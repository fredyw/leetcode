-- https://leetcode.com/problems/find-books-with-no-available-copies/description/
WITH borrow_counts AS (
    SELECT
        book_id,
        COUNT(*) AS total_borrows
    FROM borrowing_records
    WHERE return_date IS null
    GROUP BY book_id
)
SELECT
    l.book_id,
    l.title,
    l.author,
    l.genre,
    l.publication_year,
    l.total_copies AS current_borrowers
FROM library_books l JOIN borrow_counts b
    ON l.book_id = b.book_id
WHERE l.total_copies = b.total_borrows
ORDER BY l.total_copies DESC, l.title ASC;
