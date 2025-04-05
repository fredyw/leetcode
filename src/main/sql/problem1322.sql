-- https://leetcode.com/problems/ads-performance/
with total_clicked as (
    select ad_id, cast(count(*) as decimal) as count
    from Ads
    where action = 'Clicked'
    group by ad_id
), total_viewed as (
    select ad_id, cast(count(*) as decimal) as count
    from Ads
    where action = 'Viewed'
    group by ad_id
)
select c.ad_id,
       case
           when c.count + v.count = 0 then 0
           else round(c.count / (c.count + v.count) * 100, 2)
       end as ctr
from total_clicked c join total_viewed v
     on c.ad_id = v.ad_id
group by c.ad_id, ctr
order by ctr desc, c.ad_id asc;