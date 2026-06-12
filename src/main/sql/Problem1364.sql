-- https://leetcode.com/problems/number-of-trusted-contacts-of-a-customer/description/
WITH total_contacts AS (
    SELECT
        user_id,
        COUNT(*) AS contacts_cnt
    FROM contacts
    GROUP BY user_id
),

trusted_contacts AS (
    SELECT
        co.user_id,
        COUNT(cu.email) AS trusted_contacts_cnt
    FROM contacts co LEFT JOIN customers cu ON co.contact_email = cu.email
    GROUP BY co.user_id
)

SELECT
    i.invoice_id,
    cu.customer_name,
    i.price,
    COALESCE(tco.contacts_cnt, 0) AS contacts_cnt,
    COALESCE(ttr.trusted_contacts_cnt, 0) AS trusted_contacts_cnt
FROM invoices i
JOIN customers cu ON i.user_id = cu.customer_id
LEFT JOIN total_contacts tco ON cu.customer_id = tco.user_id
LEFT JOIN trusted_contacts ttr ON cu.customer_id = ttr.user_id
ORDER BY i.invoice_id;
