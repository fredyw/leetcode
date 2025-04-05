-- https://leetcode.com/problems/ads-performance/
select
    ad_id,
    case
        when sum(case when action = 'Clicked' then 1 else 0 end) +
             sum(case when action = 'Viewed' then 1 else 0 end) = 0 then 0
        else round(
            cast(sum(case when action = 'Clicked' then 1 else 0 end) as decimal) /
            (cast(sum(case when action = 'Clicked' then 1 else 0 end) as decimal) +
             cast(sum(case when action = 'Viewed' then 1 else 0 end) as decimal)) * 100, 2)
    end as ctr
from Ads
group by ad_id
order by ctr desc, ad_id asc;