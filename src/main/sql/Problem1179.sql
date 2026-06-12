-- https://leetcode.com/problems/reformat-department-table/
SELECT
    d.id,
    SUM((CASE WHEN d.month = 'Jan' THEN d.revenue ELSE null END))
        AS jan_revenue,
    SUM((CASE WHEN d.month = 'Feb' THEN d.revenue ELSE null END))
        AS feb_revenue,
    SUM((CASE WHEN d.month = 'Mar' THEN d.revenue ELSE null END))
        AS mar_revenue,
    SUM((CASE WHEN d.month = 'Apr' THEN d.revenue ELSE null END))
        AS apr_revenue,
    SUM((CASE WHEN d.month = 'May' THEN d.revenue ELSE null END))
        AS may_revenue,
    SUM((CASE WHEN d.month = 'Jun' THEN d.revenue ELSE null END))
        AS jun_revenue,
    SUM((CASE WHEN d.month = 'Jul' THEN d.revenue ELSE null END))
        AS jul_revenue,
    SUM((CASE WHEN d.month = 'Aug' THEN d.revenue ELSE null END))
        AS aug_revenue,
    SUM((CASE WHEN d.month = 'Sep' THEN d.revenue ELSE null END))
        AS sep_revenue,
    SUM((CASE WHEN d.month = 'Oct' THEN d.revenue ELSE null END))
        AS oct_revenue,
    SUM((CASE WHEN d.month = 'Nov' THEN d.revenue ELSE null END))
        AS nov_revenue,
    SUM((CASE WHEN d.month = 'Dec' THEN d.revenue ELSE null END)) AS dec_revenue
FROM department d
GROUP BY d.id;
