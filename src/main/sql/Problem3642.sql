-- https://leetcode.com/problems/find-books-with-polarized-opinions/description/
SELECT
    b.book_id,
    b.title,
    b.author,
    b.genre,
    b.pages,
    MAX(s.session_rating) - MIN(s.session_rating) AS rating_spread,
    ROUND(
        SUM(
            CASE
                WHEN
                    s.session_rating <= 2 OR s.session_rating >= 4
                    THEN 1
                ELSE 0
            END
        )
        * 1.0
        / COUNT(*), 2
    ) AS polarization_score
FROM books b JOIN reading_sessions s ON b.book_id = s.book_id
WHERE
    EXISTS (
        SELECT 1 FROM reading_sessions
        WHERE book_id = s.book_id AND session_rating <= 2
    )
    AND EXISTS (
        SELECT 1 FROM reading_sessions
        WHERE book_id = s.book_id AND session_rating >= 4
    )
GROUP BY b.book_id
HAVING
    COUNT(*) >= 5
    AND ROUND(
        SUM(
            CASE
                WHEN
                    s.session_rating <= 2 OR s.session_rating >= 4
                    THEN 1
                ELSE 0
            END
        )
        * 1.0
        / COUNT(*), 2
    ) >= 0.6
ORDER BY polarization_score DESC, b.title DESC;
