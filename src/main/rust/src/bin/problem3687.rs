// https://leetcode.com/problems/library-late-fee-calculator/description/
pub fn late_fee(days_late: Vec<i32>) -> i32 {
    days_late
        .into_iter()
        .map(|day| {
            if day == 1 {
                1
            } else if day <= 5 {
                day * 2
            } else {
                day * 3
            }
        })
        .sum()
}

fn main() {
    println!("{}", late_fee(vec![5, 1, 7])); // 32
    println!("{}", late_fee(vec![1, 1])); // 2
}
