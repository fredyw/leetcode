// https://leetcode.com/problems/binary-digit-score/description/
pub fn calculate_score(a: i32, b: i32) -> i32 {
    let x = a.count_ones() as i32;
    let y = b.count_ones() as i32;
    if x >= y { x * y } else { y / x }
}

fn main() {
    println!("{}", calculate_score(14, 6)); // 6
    println!("{}", calculate_score(5, 15)); // 2
    println!("{}", calculate_score(10, 12)); // 4
}
