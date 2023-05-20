-- https://leetcode.com/problems/biggest-single-number/
with single_numbers as (
    select num
    from MyNumbers
    group by num
    having count(num) = 1
    order by num desc
)
select max(num) as num
from single_numbers;
