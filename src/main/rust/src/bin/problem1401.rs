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
    fn find(a1: i32, a2: i32, a_center: i32) -> i32 {
        if a1 <= a_center && a_center <= a2 {
            0
        } else if a1 > a_center {
            a1 - a_center
        } else {
            // a2 > a_center
            a_center - a2
        }
    }
    find(x1, x2, x_center).pow(2) + find(y1, y2, y_center).pow(2) <= radius.pow(2)
}

fn main() {
    println!("{}", check_overlap(1, 0, 0, 1, -1, 3, 1)); // true
    println!("{}", check_overlap(1, 1, 1, 1, -3, 2, -1)); // false
    println!("{}", check_overlap(1, 0, 0, -1, 0, 0, 1)); // true
}
