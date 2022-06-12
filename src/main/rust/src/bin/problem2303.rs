// https://leetcode.com/problems/calculate-amount-paid-in-taxes/
pub fn calculate_tax(brackets: Vec<Vec<i32>>, income: i32) -> f64 {
    let mut answer = 0.0;
    for (i, e) in brackets.iter().enumerate() {
        let upper = if income < e[0] { income } else { e[0] };
        let percent = &e[1];
        let mut prev = 0;
        if i > 0 {
            let p = &brackets[i - 1];
            prev = p[0];
        }
        let tax = (upper - prev) as f64 * (*percent as f64 / 100.0) as f64;
        answer += tax;
        if income < e[0] {
            break;
        }
    }
    answer
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
