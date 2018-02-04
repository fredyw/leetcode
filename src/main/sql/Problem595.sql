-- https://leetcode.com/problems/big-countries/
select name, population, area from World where area > 3000000 || population > 25000000;