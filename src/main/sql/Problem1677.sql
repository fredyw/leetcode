-- https://leetcode.com/problems/products-worth-over-invoices/description/
select p.name,
       coalesce(sum(i.rest), 0) as rest,
       coalesce(sum(i.paid), 0) as paid,
       coalesce(sum(i.canceled), 0) as canceled,
       coalesce(sum(i.refunded), 0) as refunded
from Product p left join Invoice i
     on p.product_id = i.product_id
group by p.name
order by p.name;