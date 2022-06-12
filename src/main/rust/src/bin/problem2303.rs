// https://leetcode.com/problems/calculate-amount-paid-in-taxes/
pub fn calculate_tax(brackets: Vec<Vec<i32>>, income: i32) -> f64 {
    todo!()
}

fn main() {
    println!(
        "{}",
        calculate_tax(vec![vec![3, 50], vec![7, 10], vec![12, 25]], 10)
    ); // 2.65000
    println!(
        "{}",
        calculate_tax(vec![vec![1, 0], vec![4, 25], vec![5, 50]], 2)
    ); // 0.25000
    println!("{}", calculate_tax(vec![vec![2, 50]], 0)); // 0.00000
}
