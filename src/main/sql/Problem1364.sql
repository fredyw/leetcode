-- https://leetcode.com/problems/number-of-trusted-contacts-of-a-customer/description/
with total_contacts as (
    select user_id, count(*) as contacts_cnt
    from Contacts
    group by user_id
),
trusted_contacts as (
    select co.user_id, count(cu.email) as trusted_contacts_cnt
    from Contacts co left join Customers cu on co.contact_email = cu.email
    group by co.user_id
)
select i.invoice_id,
       cu.customer_name,
       i.price,
       coalesce(tco.contacts_cnt, 0) as contacts_cnt,
       coalesce(ttr.trusted_contacts_cnt, 0) as trusted_contacts_cnt
from Invoices i
     join Customers cu on i.user_id = cu.customer_id
     left join total_contacts tco on cu.customer_id = tco.user_id
     left join trusted_contacts ttr on cu.customer_id = ttr.user_id
order by i.invoice_id;
