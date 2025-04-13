-- https://leetcode.com/problems/classifying-triangles-by-lengths/
select
    case
        when A + B > C and A + C > B and B + C > A then
            case
                when A = B and B = C and A = C then 'Equilateral'
                when A != B and B != C and A != C then 'Scalene'
                else 'Isosceles'
            end
        else 'Not A Triangle'
    end as triangle_type
from Triangles;