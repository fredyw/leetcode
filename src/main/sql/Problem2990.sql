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

SELECT user_id FROM Loans
WHERE loan_type = 'Mortgage'
INTERSECT
SELECT user_id FROM Loans
WHERE loan_type = 'Refinance'
ORDER BY user_id;
