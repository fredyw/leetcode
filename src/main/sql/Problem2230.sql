-- https://leetcode.com/problems/the-users-that-are-eligible-for-discount/
CREATE OR REPLACE FUNCTION GETUSERIDS(
    startDate date, endDate date, minAmount int
)
RETURNS TABLE (user_id int) AS $$
begin
    return query (
        select distinct p.user_id
        from Purchases p
        where p.time_stamp between startDate and endDate
              and p.amount >= minAmount
        order by p.user_id
    );
end;
$$ LANGUAGE plpgsql;
