-- https://leetcode.com/problems/warehouse-manager/description/
SELECT
    w.name AS warehouse_name,
    SUM(w.units * p.width * p.length * p.height) AS volume
FROM Warehouse w JOIN Products p
    ON (w.product_id = p.product_id)
GROUP BY w.name;
