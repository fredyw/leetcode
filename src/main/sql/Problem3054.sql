-- https://leetcode.com/problems/binary-tree-nodes/description/
select n, 'Root' as type
from tree
where p is null
union
select distinct p, 'Inner' as type
from tree
where p is not null
  and p != (select n from tree where p is null)
union
select n, 'Leaf' as type
from tree
where n not in (select p from tree where p is not null)
  and p is not null
order by n;
