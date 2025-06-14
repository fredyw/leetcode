-- https://leetcode.com/problems/get-highest-answer-rate-question/description/
select t.question_id as survey_log 
from (
    select question_id,
           sum(case when answer_id is not null then 1 else 0 end) /
           count(distinct question_id) as answer
    from SurveyLog
    where action = 'answer'
    group by question_id
) t
order by t.answer desc
limit 1;