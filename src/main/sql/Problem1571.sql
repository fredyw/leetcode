-- https://leetcode.com/problems/warehouse-manager/description/
select w.name as warehouse_name,
       sum(w.units * p.width * p.length * p.height) as volume
from Warehouse w join Products p
     on (w.product_id = p.product_id)
group by w.name;
