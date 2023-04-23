// https://leetcode.com/problems/find-the-substring-with-maximum-cost/
pub fn maximum_cost_substring(s: String, chars: String, vals: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        maximum_cost_substring("adaa".to_string(), "d".to_string(), vec![-1000])
    ); // 2
    println!(
        "{}",
        maximum_cost_substring("abc".to_string(), "abc".to_string(), vec![-1, -1, -1])
    ); // 0
    println!(
        "{}",
        maximum_cost_substring("adaa".to_string(), "d".to_string(), vec![1000])
    ); // 1003
}
