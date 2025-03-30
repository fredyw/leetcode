-- https://leetcode.com/problems/sellers-with-no-sales/description/
select seller_name
from Seller
where seller_id not in (
    select distinct seller_id
    from Orders
    where extract(year from sale_date) = 2020
)
order by seller_name;