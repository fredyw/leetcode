-- https://leetcode.com/problems/find-customers-with-positive-revenue-this-year/description/
select customer_id
from Customers
where year = 2021 and revenue > 0;
