-- https://leetcode.com/problems/loan-types/description/
-- select l1.user_id
-- from Loans l1
-- where exists (select 1 from Loans l2
--               where l1.user_id = l2.user_id
--                     and l2.loan_type = 'Refinance')
--       and exists (select 1 from Loans l2
--                   where l1.user_id = l2.user_id
--                   and l2.loan_type = 'Mortgage')
-- group by l1.user_id
-- order by l1.user_id;

select user_id from Loans where loan_type = 'Mortgage'
intersect
select user_id from Loans where loan_type = 'Refinance'
order by user_id;