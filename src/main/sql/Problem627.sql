-- https://leetcode.com/problems/swap-salary/
update salary
set sex = case
          when sex = 'm' then 'f'
          else 'm'
          end;