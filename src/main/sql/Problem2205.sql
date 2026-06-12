-- https://leetcode.com/problems/the-number-of-users-that-are-eligible-for-discount/
CREATE OR REPLACE FUNCTION GETUSERIDS(
    startDate date, endDate date, minAmount int
) RETURNS int AS $$
begin
    return (
	    select count(distinct user_id) as user_cnt
        from Purchases
        where time_stamp between startDate and endDate
              and amount >= minAmount
    );
end;
$$ LANGUAGE plpgsql;
