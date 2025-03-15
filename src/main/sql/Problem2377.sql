-- https://leetcode.com/problems/sort-the-olympic-table/description/
select country, gold_medals, silver_medals, bronze_medals
from Olympic
order by gold_medals desc,
         silver_medals desc,
         bronze_medals desc,
         country asc;
