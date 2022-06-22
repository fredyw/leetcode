// https://leetcode.com/problems/circle-and-rectangle-overlapping/
pub fn check_overlap(
    radius: i32,
    x_center: i32,
    y_center: i32,
    x1: i32,
    y1: i32,
    x2: i32,
    y2: i32,
) -> bool {
    todo!()
}

fn main() {
    println!("{}", check_overlap(1, 0, 0, 1, -1, 3, 1)); // true
    println!("{}", check_overlap(1, 1, 1, 1, -3, 2, -1)); // false
    println!("{}", check_overlap(1, 0, 0, -1, 0, 0, 1)); // true
}
