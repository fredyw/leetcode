-- https://leetcode.com/problems/the-winner-university/description/
with new_york_excellent as (
    select count(*) as count
    from NewYork
    where score >= 90
), california_excellent as (
    select count(*) as count
    from California
    where score >= 90
)
select
    case
        when (select count from new_york_excellent) >
             (select count from california_excellent) then 'New York University'
        when (select count from new_york_excellent) <
             (select count from california_excellent) then 'California University'
        else 'No Winner'
    end as winner;
