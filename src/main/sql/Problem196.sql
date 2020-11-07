-- https://leetcode.com/problems/delete-duplicate-emails/

-- delete p1
-- from Person p1, Person p2
-- where p1.Email = p2.Email and p1.Id > p2.Id;

delete from Person
where Id not in (
    select t.Id from (
        select min(Id) as Id
        from Person
        group by Email
    ) as t
);
