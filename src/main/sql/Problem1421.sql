-- https://leetcode.com/problems/npv-queries/
select q.id, q.year, coalesce(n.npv, 0) as npv
from Queries q left join NPV n
     on n.id = q.id and n.year = q.year;
