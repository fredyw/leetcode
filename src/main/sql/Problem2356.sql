-- https://leetcode.com/problems/number-of-unique-subjects-taught-by-each-teacher/
SELECT
    teacher_id,
    COUNT(DISTINCT subject_id) AS cnt
FROM teacher
GROUP BY teacher_id;
