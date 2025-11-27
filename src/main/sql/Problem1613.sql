-- https://leetcode.com/problems/find-the-missing-ids/description/
select t.id as ids
from generate_series(1, (select max(customer_id) from Customers)) as t(id)
where t.id not in (select customer_id from Customers)
order by t.id;
