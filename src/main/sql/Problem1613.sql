-- https://leetcode.com/problems/find-the-missing-ids/description/
SELECT t.id AS ids
FROM GENERATE_SERIES(1, (SELECT MAX(customer_id) FROM Customers)) AS t (id)
WHERE t.id NOT IN (SELECT customer_id FROM Customers)
ORDER BY t.id;
