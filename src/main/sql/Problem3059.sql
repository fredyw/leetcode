-- https://leetcode.com/problems/find-all-unique-email-domains/description/
select substring(email FROM '@(.*\.com)$') as email_domain,
       count(*) as count
from Emails
where substring(email FROM '@(.*\.com)$') is not null
group by email_domain
order by email_domain;