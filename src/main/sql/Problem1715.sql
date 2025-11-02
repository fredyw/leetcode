-- https://leetcode.com/problems/count-apples-and-oranges/description/
with t as (
    select apple_count, orange_count
    from Boxes
    where chest_id is null
    union all
    select (b.apple_count + c.apple_count) as apple_count,
           (b.orange_count + c.orange_count) as orange_count
    from Boxes b join Chests c on b.chest_id = c.chest_id
)
select sum(apple_count) as apple_count, sum(orange_count) as orange_count
from t;
