-- https://leetcode.com/problems/reformat-department-table/
SELECT
    d.id,
    SUM((CASE WHEN d.month = 'Jan' THEN d.revenue ELSE null END))
        AS Jan_Revenue,
    SUM((CASE WHEN d.month = 'Feb' THEN d.revenue ELSE null END))
        AS Feb_Revenue,
    SUM((CASE WHEN d.month = 'Mar' THEN d.revenue ELSE null END))
        AS Mar_Revenue,
    SUM((CASE WHEN d.month = 'Apr' THEN d.revenue ELSE null END))
        AS Apr_Revenue,
    SUM((CASE WHEN d.month = 'May' THEN d.revenue ELSE null END))
        AS May_Revenue,
    SUM((CASE WHEN d.month = 'Jun' THEN d.revenue ELSE null END))
        AS Jun_Revenue,
    SUM((CASE WHEN d.month = 'Jul' THEN d.revenue ELSE null END))
        AS Jul_Revenue,
    SUM((CASE WHEN d.month = 'Aug' THEN d.revenue ELSE null END))
        AS Aug_Revenue,
    SUM((CASE WHEN d.month = 'Sep' THEN d.revenue ELSE null END))
        AS Sep_Revenue,
    SUM((CASE WHEN d.month = 'Oct' THEN d.revenue ELSE null END))
        AS Oct_Revenue,
    SUM((CASE WHEN d.month = 'Nov' THEN d.revenue ELSE null END))
        AS Nov_Revenue,
    SUM((CASE WHEN d.month = 'Dec' THEN d.revenue ELSE null END)) AS Dec_Revenue
FROM Department d
GROUP BY d.id;
