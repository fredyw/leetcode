-- https://leetcode.com/problems/tasks-count-in-the-weekend/description/
select (
    select count(*)
    from Tasks
    where extract(dow from submit_date) in (0, 6) 
) as weekend_cnt, (
    select count(*)
    from Tasks
    where extract(dow from submit_date) not in (0, 6)
) as working_cnt;