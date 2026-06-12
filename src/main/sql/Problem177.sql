-- https://leetcode.com/problems/nth-highest-salary/
CREATE OR REPLACE FUNCTION GETNTHHIGHESTSALARY(N INT) RETURNS INT AS $$
DECLARE
    M INT;
BEGIN
    M := N - 1;
    RETURN (
        SELECT DISTINCT salary
        FROM employee
        ORDER BY salary DESC
        LIMIT 1 OFFSET M
    );
END;
$$ LANGUAGE plpgsql;
