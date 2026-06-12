-- https://leetcode.com/problems/find-all-unique-email-domains/description/
SELECT
    SUBSTRING(email FROM '@(.*\.com)$') AS email_domain,
    COUNT(*) AS count
FROM Emails
WHERE SUBSTRING(email FROM '@(.*\.com)$') IS NOT null
GROUP BY email_domain
ORDER BY email_domain;
