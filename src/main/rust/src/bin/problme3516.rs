// https://leetcode.com/problems/find-closest-person/description/
pub fn find_closest(x: i32, y: i32, z: i32) -> i32 {
    if (x - z).abs() < (y - z).abs() {
        1
    } else if (x - z).abs() > (y - z).abs() {
        2
    } else {
        0
    }
}

fn main() {
    println!("{}", find_closest(2, 7, 4)); // 1
    println!("{}", find_closest(2, 5, 6)); // 2
    println!("{}", find_closest(1, 5, 3)); // 0
}
