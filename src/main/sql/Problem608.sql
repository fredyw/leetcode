-- https://leetcode.com/problems/tree-node/
select id, 'Root' as type
from tree
where p_id is null
union
select distinct p_id, 'Inner' as type
from tree
where p_id is not null
  and p_id != (select id from tree where p_id is null)
union
select id, 'Leaf' as type
from tree
where id not in (select p_id from tree where p_id is not null)
  and p_id is not null
order by id;