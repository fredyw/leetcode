-- https://leetcode.com/problems/daily-leads-and-partners/
SELECT
    date_id,
    make_name,
    COUNT(DISTINCT lead_id) AS unique_leads,
    COUNT(DISTINCT partner_id) AS unique_partners
FROM dailysales
GROUP BY date_id, make_name;
