-- https://leetcode.com/problems/sort-the-olympic-table/description/
SELECT
    country,
    gold_medals,
    silver_medals,
    bronze_medals
FROM olympic
ORDER BY
    gold_medals DESC,
    silver_medals DESC,
    bronze_medals DESC,
    country ASC;
