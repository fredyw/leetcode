-- https://leetcode.com/problems/all-valid-triplets-that-can-represent-a-country/description/
SELECT
    a.student_name AS member_a,
    b.student_name AS member_b,
    c.student_name AS member_c
FROM schoola a, schoolb b, schoolc c
WHERE
    a.student_id != b.student_id
    AND b.student_id != c.student_id
    AND a.student_id != c.student_id
    AND a.student_name != b.student_name
    AND b.student_name != c.student_name
    AND a.student_name != c.student_name;
