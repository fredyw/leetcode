-- https://leetcode.com/problems/number-of-calls-between-two-persons/description/
with t as (
    select
        case when from_id < to_id then from_id else to_id end as person1,
        case when from_id > to_id then from_id else to_id end as person2,
        duration
    from Calls
)
select person1, person2, count(*) as call_count, sum(duration) as total_duration
from t
group by person1, person2;
