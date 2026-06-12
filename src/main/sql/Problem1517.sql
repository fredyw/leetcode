-- https://leetcode.com/problems/find-users-with-valid-e-mails/description/
SELECT
    user_id,
    name,
    mail
FROM users
WHERE
    REGEXP_LIKE(mail, '^[:alpha:][[:alnum:]|\\-._]*@leetcode\\.com$', 'i') = 1;
