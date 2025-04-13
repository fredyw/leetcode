-- https://leetcode.com/problems/the-users-that-are-eligible-for-discount/
create or replace function getUserIDs(startDate date, endDate date, minAmount int)
returns table (user_id int) as $$
begin
    return query (
        select distinct p.user_id
        from Purchases p
        where p.time_stamp between startDate and endDate
              and p.amount >= minAmount
        order by p.user_id
    );
end;
$$ language plpgsql;