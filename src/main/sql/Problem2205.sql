-- https://leetcode.com/problems/the-number-of-users-that-are-eligible-for-discount/
create or replace function getUserIDs(startDate date, endDate date, minAmount int) returns int as $$
begin
    return (
	    select count(distinct user_id) as user_cnt
        from Purchases
        where time_stamp between startDate and endDate
              and amount >= minAmount
    );
end;
$$ language plpgsql;