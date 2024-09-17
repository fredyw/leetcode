-- https://leetcode.com/problems/calculate-compressed-mean/description/
select round(sum(item_count * order_occurrences) / cast(sum(order_occurrences) as decimal), 2)
       as average_items_per_order
from Orders;
