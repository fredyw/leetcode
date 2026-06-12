-- https://leetcode.com/problems/classifying-triangles-by-lengths/
SELECT
    CASE
        WHEN A + B > C AND A + C > B AND B + C > A
            THEN
                CASE
                    WHEN A = B AND B = C AND A = C THEN 'Equilateral'
                    WHEN A != B AND B != C AND A != C THEN 'Scalene'
                    ELSE 'Isosceles'
                END
        ELSE 'Not A Triangle'
    END AS TRIANGLE_TYPE
FROM TRIANGLES;
