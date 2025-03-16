-- https://leetcode.com/problems/concatenate-the-name-and-the-profession/
select person_id,
       name || '(' || substring(profession, 1, 1) || ')' as name
from Person
order by person_id desc;
