-- https://leetcode.com/problems/friend-requests-i-overall-acceptance-rate/description/
with request_sent_count as (
    select cast(count(*) as decimal) as count from (
        select distinct sender_id, send_to_id
        from FriendRequest
    )
),
request_accepted_count as (
select cast(count(*) as decimal) as count from (
        select distinct requester_id, accepter_id
        from RequestAccepted
    )
)
select
    case
        when (select count from request_sent_count) = 0 then 0.0
        else round((select count from request_accepted_count) /
                   (select count from request_sent_count), 2)
    end as accept_rate;
