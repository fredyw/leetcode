-- https://leetcode.com/problems/immediate-food-delivery-i/description/
with immediate_orders as (
    select cast(count(*) as decimal) as count
    from Delivery
    where order_date = customer_pref_delivery_date
), total_orders as (
    select cast(count(*) as decimal) as count
    from Delivery
)
select round(
    ((select count from immediate_orders) / (select count from total_orders) * 100),
    2
) as immediate_percentage;