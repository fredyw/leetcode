-- https://leetcode.com/problems/the-number-of-employees-which-report-to-each-employee/description/
SELECT
    e1.employee_id,
    e1.name,
    COUNT(*) AS reports_count,
    ROUND(AVG(e2.age)) AS average_age
FROM employees e1 JOIN employees e2
    ON e1.employee_id = e2.reports_to
GROUP BY e1.employee_id, e1.name
ORDER BY e1.employee_id;
