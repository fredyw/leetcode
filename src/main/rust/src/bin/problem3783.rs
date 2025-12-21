// https://leetcode.com/problems/mirror-distance-of-an-integer/description/
pub fn mirror_distance(n: i32) -> i32 {
    let r: i32 = n
        .to_string()
        .chars()
        .rev()
        .collect::<String>()
        .parse()
        .unwrap();
    (n - r).abs()
}

fn main() {
    println!("{}", mirror_distance(25)); // 27
    println!("{}", mirror_distance(10)); // 9
    println!("{}", mirror_distance(7)); // 0
}
