-- https://leetcode.com/problems/reformat-department-table/
select d.id,
       sum((case when d.month = 'Jan' then d.revenue else null end)) as Jan_Revenue,
       sum((case when d.month = 'Feb' then d.revenue else null end)) as Feb_Revenue,
       sum((case when d.month = 'Mar' then d.revenue else null end)) as Mar_Revenue,
       sum((case when d.month = 'Apr' then d.revenue else null end)) as Apr_Revenue,
       sum((case when d.month = 'May' then d.revenue else null end)) as May_Revenue,
       sum((case when d.month = 'Jun' then d.revenue else null end)) as Jun_Revenue,
       sum((case when d.month = 'Jul' then d.revenue else null end)) as Jul_Revenue,
       sum((case when d.month = 'Aug' then d.revenue else null end)) as Aug_Revenue,
       sum((case when d.month = 'Sep' then d.revenue else null end)) as Sep_Revenue,
       sum((case when d.month = 'Oct' then d.revenue else null end)) as Oct_Revenue,
       sum((case when d.month = 'Nov' then d.revenue else null end)) as Nov_Revenue,
       sum((case when d.month = 'Dec' then d.revenue else null end)) as Dec_Revenue
from Department d
group by d.id;
