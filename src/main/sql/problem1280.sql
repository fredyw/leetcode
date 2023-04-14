-- https://leetcode.com/problems/students-and-examinations/description/
select s.student_id,
       s.student_name,
       u.subject_name,
       count(e.subject_name) as attended_exams
from Students s join Subjects u left join Examinations e
     on s.student_id = e.student_id and u.subject_name = e.subject_name
group by s.student_id, s.student_name, u.subject_name
order by s.student_id, u.subject_name;
