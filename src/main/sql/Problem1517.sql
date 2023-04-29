-- https://leetcode.com/problems/find-users-with-valid-e-mails/description/
select user_id, name, mail
from Users
where regexp_like(mail, '^[:alpha:][[:alnum:]|\\-._]*@leetcode\\.com$', 'i') = 1;
