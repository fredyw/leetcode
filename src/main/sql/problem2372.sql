-- https://leetcode.com/problems/calculate-the-influence-of-each-salesperson/description/
SELECT
    sp.salesperson_id,
    sp.name,
    COALESCE(SUM(s.price), 0) AS total
FROM customer c JOIN sales s
    ON c.customer_id = s.customer_id
RIGHT JOIN salesperson sp
    ON sp.salesperson_id = c.salesperson_id
GROUP BY sp.salesperson_id, sp.name;
