// https://leetcode.com/problems/construct-the-longest-new-string/
pub fn longest_string(x: i32, y: i32, z: i32) -> i32 {
    if x == y {
        (x * 2) + (y * 2) + (z * 2)
    } else {
        let min = x.min(y);
        (min * 2) + ((min + 1) * 2) + (z * 2)
    }
}

fn main() {
    println!("{}", longest_string(2, 5, 1)); // 12
    println!("{}", longest_string(3, 2, 2)); // 14
    println!("{}", longest_string(40, 50, 24)); // 210
}
