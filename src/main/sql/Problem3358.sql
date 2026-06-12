-- https://leetcode.com/problems/books-with-null-ratings/description/
SELECT
    book_id,
    title,
    author,
    published_year
FROM books
WHERE rating IS null
ORDER BY book_id;
