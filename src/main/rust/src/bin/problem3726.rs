// https://leetcode.com/problems/remove-zeros-in-decimal-representation/description/
pub fn remove_zeros(n: i64) -> i64 {
    n.to_string()
        .chars()
        .filter(|c| *c != '0')
        .collect::<String>()
        .parse()
        .unwrap()
}

fn main() {
    println!("{}", remove_zeros(1020030)); // 123
    println!("{}", remove_zeros(1)); // 1
}
