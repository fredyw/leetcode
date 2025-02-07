// https://leetcode.com/problems/maximize-total-tastiness-of-purchased-fruits/description/
pub fn max_tastiness(
    price: Vec<i32>,
    tastiness: Vec<i32>,
    max_amount: i32,
    max_coupons: i32,
) -> i32 {
    fn max_tastiness(
        price: &Vec<i32>,
        tastiness: &Vec<i32>,
        max_amount: i32,
        max_coupons: i32,
        index: usize,
    ) -> Option<i32> {
        if max_amount < 0 {
            return None;
        }
        if index == price.len() {
            return Some(0);
        }
        let eat_without_coupon = if let Some(t) = max_tastiness(
            price,
            tastiness,
            max_amount - price[index],
            max_coupons,
            index + 1,
        ) {
            t + tastiness[index]
        } else {
            0
        };
        let eat_with_coupon = if let Some(t) = max_tastiness(
            price,
            tastiness,
            max_amount - (price[index] / 2),
            max_coupons - 1,
            index + 1,
        ) {
            t + tastiness[index]
        } else {
            0
        };
        let dont_eat = if let Some(t) =
            max_tastiness(price, tastiness, max_amount, max_coupons - 1, index + 1)
        {
            t
        } else {
            0
        };
        let max_tastiness = eat_without_coupon.max(eat_with_coupon.max(dont_eat));
        Some(max_tastiness)
    }

    max_tastiness(&price, &tastiness, max_amount, max_coupons, 0).unwrap_or(0)
}

fn main() {
    println!("{}", max_tastiness(vec![10, 20, 20], vec![5, 8, 8], 20, 1)); // 13
    println!("{}", max_tastiness(vec![10, 15, 7], vec![5, 8, 20], 10, 2)); // 28
    println!("{}", max_tastiness(vec![10, 15, 7], vec![5, 8, 20], 1, 2)); // 0
}
