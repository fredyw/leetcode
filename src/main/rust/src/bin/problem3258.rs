// https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/description/
pub fn count_k_constraint_substrings(s: String, k: i32) -> i32 {
    todo!()
}

fn main() {
    println!("{}", count_k_constraint_substrings("10101".to_string(), 1)); // 12
    println!(
        "{}",
        count_k_constraint_substrings("1010101".to_string(), 2)
    ); // 25
    println!("{}", count_k_constraint_substrings("11111".to_string(), 1)); // 15
}
