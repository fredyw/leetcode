-- https://leetcode.com/problems/the-first-day-of-the-maximum-recorded-degree-in-each-city/
with t as (
    select city_id,
           day,
           degree,
           rank() over (partition by city_id order by degree desc, day asc) as rnk
    from Weather
)
select city_id, day, degree
from t
where rnk = 1
order by city_id;
