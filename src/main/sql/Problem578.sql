-- https://leetcode.com/problems/get-highest-answer-rate-question/description/
SELECT t.question_id AS survey_log
FROM (
    SELECT
        question_id,
        SUM(CASE WHEN answer_id IS NOT null THEN 1 ELSE 0 END)
        / COUNT(DISTINCT question_id) AS answer
    FROM surveylog
    WHERE action = 'answer'
    GROUP BY question_id
) t
ORDER BY t.answer DESC
LIMIT 1;
