-- https://leetcode.com/problems/find-customers-with-positive-revenue-this-year/description/
SELECT customer_id
FROM customers
WHERE year = 2021 AND revenue > 0;
