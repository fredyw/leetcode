-- https://leetcode.com/problems/the-number-of-rich-customers/description/
SELECT COUNT(DISTINCT customer_id) AS rich_count
FROM store
WHERE amount > 500;
